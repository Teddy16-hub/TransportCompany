import dao.*;
import entity.*;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Company company = new Company();
        company.setId(1);
        company.setName("Hershey");
        CompanyDAO.saveCompany(company);
        List<Company> companies = Arrays.asList(new Company(2, "Barca"), new Company(3, "Union"));
        CompanyDAO.saveCompanies(companies);
        companies = CompanyDAO.readCompanies();
        companies = CompanyDAO.sortCompaniesByNameAndIncomes();
        System.out.println("\n Sort companies by name and incomes\n");
        companies.stream().forEach(System.out::println);
        System.out.println("\n\n");

        Employee aspen = new Employee(1, "aspen", TypeOfQualification.FLAMMABLE, BigDecimal.valueOf(1500), company);
        EmployeeDAO.saveEmployee(aspen);
        Employee john = new Employee(2, "John", TypeOfQualification.OVERSIZE_LOAD, BigDecimal.valueOf(1700), company);
        EmployeeDAO.saveEmployee(john);
        Employee ana = new Employee(3, "Ana", TypeOfQualification.SPECIAL_LOAD, BigDecimal.valueOf(1300), companies.get(2));
        EmployeeDAO.saveEmployee(ana);
        Employee martha = new Employee(4, "Martha", TypeOfQualification.SPECIAL_LOAD, BigDecimal.valueOf(1400), companies.get(1));
        EmployeeDAO.saveEmployee(martha);
        List<Employee> employees = List.of(new Employee(5, "Peter", TypeOfQualification.GREATER_THAN_12_PASSENGERS, BigDecimal.valueOf(1300), companies.get(0)));
        EmployeeDAO.saveEmployees(employees);
        //Employee sasha = new Employee(6, "Sasha", TypeOfQualification.OVERSIZE_LOAD, BigDecimal.valueOf(1200), companies.get(2));
        //EmployeeDAO.saveEmployee(sasha);
        employees = EmployeeDAO.readEmployees();
        employees = EmployeeDAO.sortEmployeeByQualificationAndSalary();
        System.out.println("\nEmployees\n");
        System.out.println("Qualifications are compared by their first letter. The salaries are compared from the biggest to the smallest for the same qualification");
        employees.stream().forEach(System.out::println);
        System.out.println("\n");

        Transportation transportation1 = new Transportation(1, "London", "Oslo", LocalDate.of(2021, 9, 16), LocalDate.of(2021, 9, 22), 2, BigDecimal.valueOf(678.00), company, aspen);
        TransportationDAO.saveTransportation(transportation1);
        Transportation transportation2 = new Transportation(2, "Montreal", "Seattle", LocalDate.of(2021, 10, 1), LocalDate.of(2021, 10, 8), 1, BigDecimal.valueOf(876.00), companies.get(1), ana);
        TransportationDAO.saveTransportation(transportation2);
        Transportation transportation3 = new Transportation(3, "Canberra", "Sydney", LocalDate.of(2020, 7, 17), LocalDate.of(2020, 8, 12), 2, BigDecimal.valueOf(870.00), company, john);
        TransportationDAO.saveTransportation(transportation3);
        Transportation transportation4 = new Transportation(4, "Dublin", "Stockholm", LocalDate.of(2020, 5, 12), LocalDate.of(2020, 6, 7), 1, BigDecimal.valueOf(650.00), company, john);
        TransportationDAO.saveTransportation(transportation4);
        Transportation transportation5 = new Transportation(5, "Miami", "Dallas", LocalDate.of(2021, 8, 20), LocalDate.of(2021, 9, 18), 2, BigDecimal.valueOf(780.00), company, john);
        TransportationDAO.saveTransportation(transportation5);
        List<Transportation> transportations = Arrays.asList(new Transportation(6, "Vienna", "London", LocalDate.of(2021, 11, 9), LocalDate.of(2021, 12, 8), 1, BigDecimal.valueOf(654.00), companies.get(companies.size() - 1), martha), new Transportation(7, "New York", "Boston", LocalDate.of(2021, 5, 17), LocalDate.of(2022, 6, 23), 2, BigDecimal.valueOf(320.00), companies.get(0), martha));
        TransportationDAO.saveTransportations(transportations);
        //Transportation transportation6 = new Transportation(6, "Chicago", "Boston, LocalDate.of(2021, 6, 19), LocalDate.of(2021, 8, 2), 2, BigDecimal.valueOf(566.00), companies.get(1), john);
        //TransportationDAO.saveTransportation(transportation4);
        transportations = TransportationDAO.readTransportations();
        transportations = TransportationDAO.sortTransportationOrderByDestination();
        System.out.println("\nSort and filter transportations by destination\n");
        System.out.println("Transportations are compared by the name of the starting point and by the name of the ending point");
        transportations.stream().forEach(System.out::println);
        FileWriter writer = null;
        String msg = "\n FOR TRANSPORTATIONS\n";
        try {
            writer = new FileWriter("files/TransportationsData.txt", true);
            writer.write(msg);
            for (Transportation transportation : transportations) {
                writer.write(transportation + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (IOException e) {
            System.out.println("IOException " + e);
        }
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        String currLine;
        try (FileReader fis = new FileReader("files/TransportationsData.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fis);
            while ((currLine = bufferedReader.readLine()) != null) {
                System.out.println(currLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Company c: companies){
            Long number = TransportationDAO.getNumberOfTransportationsByCompany(c);
            System.out.println("\n Number of transportations for companies");
            System.out.println("\n" + c.getName() + " - " + number + " transportations\n");
        }
        for(Company c: companies){
            BigDecimal s = TransportationDAO.sumOfTransportationsForOneCompany(c);
            System.out.println("\n Sum of the price of transportations for companies");
            System.out.println("\n" + c.getName() + " - " + s + "$\n");
        }
        for(Employee e: employees){
            Long number = TransportationDAO.listOfEmployeesAndTheirTransportations(e);
            System.out.println("\n Employees and their transportations\n");
            System.out.println("\n" + e.getName() + " - " + number + " transportations\n");
        }
        for(Employee employee: employees){
            BigDecimal i = TransportationDAO.incomeForEmployee(employee);
            System.out.println("\n Incomes from an employee");
            System.out.println("\n" + employee.getName() + " - " + i + "$\n");
        }
        Client austin = new Client(1, "Austin", transportation1,true);
        ClientDAO.saveClient(austin);
        Client josh = new Client(2, "Josh", transportation2, false);
        ClientDAO.saveClient(josh);
        Client devan = new Client(3, "Devan", transportation3, true);
        ClientDAO.saveClient(devan);
        List<Client> clients = Arrays.asList(new Client(4, "Anna", transportation4, true), new Client(5, "Loren", transportation5, false));
        ClientDAO.saveClients(clients);
        //Client andrew = new Client(6, "Andrew", transportation5, true);
        //ClientDAO.saveClient(andrew);
        clients = ClientDAO.readClients();
        System.out.println("\n Clients\n");
        clients.stream().forEach(System.out::println);
        System.out.println("\n\n");

        Good good1 = new Good(1, "water", BigDecimal.valueOf(500.00), transportation1);
        GoodDAO.saveGood(good1);
        List<Good> goods = Arrays.asList(new Good(2, "soda", BigDecimal.valueOf(400.00), transportation2), new Good(3, "veggies", BigDecimal.valueOf(600.00), transportation5), new Good(4, "sweets", BigDecimal.valueOf(490.00), transportation2), new Good(5, "hangers", BigDecimal.valueOf(510.00), transportation1));
        GoodDAO.saveGoods(goods);
        goods = GoodDAO.readGoods();
        System.out.println("\n        Goods         \n");
        goods.stream().forEach(System.out::println);
        System.out.println("\n\n");
        Vehicle vehicle1 = new Vehicle(1, TypeOfVehicle.TRUCK, company);
        VehicleDAO.saveVehicle(vehicle1);
        Vehicle vehicle2 = new Vehicle(2, TypeOfVehicle.CISTERN, companies.get(0));
        VehicleDAO.saveVehicle(vehicle2);
        Vehicle vehicle3 = new Vehicle(3, TypeOfVehicle.TRUCK, companies.get(1));
        VehicleDAO.saveVehicle(vehicle3);
        Vehicle vehicle4 = new Vehicle(4, TypeOfVehicle.BUS, companies.get(2));
        VehicleDAO.saveVehicle(vehicle4);
        Vehicle vehicle5 = new Vehicle(5, TypeOfVehicle.CISTERN, companies.get(3));
        VehicleDAO.saveVehicle(vehicle5);
        List<Vehicle> vehicles = Arrays.asList(new Vehicle(5, TypeOfVehicle.TRUCK, company), new Vehicle(6, TypeOfVehicle.BUS, companies.get(1)));
        VehicleDAO.saveVehicles(vehicles);
        vehicles = VehicleDAO.readVehicles();
        System.out.println("\n         Vehicles          \n");
        vehicles.stream().forEach(System.out::println);
        System.out.println("\n\n");
   }
}