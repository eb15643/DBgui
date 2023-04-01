package project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class GUIcontroller {

        @FXML
        private Button btnDelete;

        @FXML
        private Button btnInsert;

        @FXML
        private Button btnUpdate;

        @FXML
        private TableView<Employee> tvEmployees;

        @FXML
        private TableColumn<Employee, Integer> cold_num;

        @FXML
        private TableColumn<Employee, Integer> cole_ssn;

        @FXML
        private TableColumn<Employee, String> colf_name;

        @FXML
        private TableColumn<Employee, String> coll_name;

        @FXML
        private TableColumn<Employee, Integer> colsuperssn;

        @FXML
        private TextField tfd_num;

        @FXML
        private TextField tfe_ssn;

        @FXML
        private TextField tff_name;

        @FXML
        private TextField tfl_name;

        @FXML
        private TextField tfsuperssn;



        @FXML
        public void initialize(URL url, ResourceBundle rb){
                showEmployees();
        }
        public Connection getConnection(){
                Connection conn;
                try{
                      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Heimerdinger4216");
                      return conn;
                }catch(Exception ex){
                        System.out.println("Error: "+ ex.getMessage());
                        return null;
                }
        }

        public ObservableList<Employee> getEmployeeList(){
                ObservableList<Employee> employeeList = FXCollections.observableArrayList();
                Connection conn = getConnection();
                String query = "SELECT * FROM employee";
                Statement st;
                ResultSet rs;

                try{
                     st = conn.createStatement();
                     rs = st.executeQuery(query);
                     Employee employee;
                     while(rs.next()){
                             employee = new Employee(rs.getString("fname"), rs.getString("lname"), rs.getInt("ssn"), rs.getInt("dno"), rs.getInt("superssn"));
                             employeeList.add(employee);
                     }
                }catch(Exception ex){
                        ex.printStackTrace();
                }
                return employeeList;
        }
        public void showEmployees(){
                ObservableList<Employee> list = getEmployeeList();
                colf_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("f_name"));
                coll_name.setCellValueFactory(new PropertyValueFactory<Employee, String>("l_name"));
                cole_ssn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("e_ssn"));
                cold_num.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("d_num"));
                colsuperssn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("superssn"));

                tvEmployees.setItems(list);

        }

}
