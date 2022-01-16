/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Modeller.FoodList;
import javafx.scene.control.*;
import java.net.URL;
import java.sql.*;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ConToDB.DBConnection;


/**
 * FXML Controller class
 *
 * @author samuel
 */
public class MenuUtamaController extends MultipleScene implements Initializable {

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnLogOut;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNamaProduk;
    @FXML
    private TextField tfHarga;
    @FXML
    private TextField tfDeskripsi;
    @FXML
    private Label menuUtamaLabel;
    @FXML
    private TableView<FoodList> tvFoodList;
    @FXML
    private TableColumn<FoodList, Integer> colId;
    @FXML
    private TableColumn<FoodList, String> colNamaProduk;
    @FXML
    private TableColumn<FoodList, Integer> colHarga;
    @FXML
    private TableColumn<FoodList, String> colDeskripsi;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        showFood();
    }
    
        //Handle Add, Update, Remove Button
    @FXML
    private void handleButtonAction(ActionEvent event){
        if(event.getSource()== btnAdd){
            addRecord();
        }else if(event.getSource()== btnUpdate){
            updateRecord();       
        }else if(event.getSource()== btnRemove){
            removeRecord();
        }else if(event.getSource()==btnLogOut){
        }   
    }
    
    @FXML
    private void handleMouseClicked(MouseEvent event){
        FoodList food = tvFoodList.getSelectionModel().getSelectedItem();
        if(colId.getCellData(food) != null){
                tfId.setText(""+ food.getId());
                tfNamaProduk.setText(food.getNamaProduk());
                tfHarga.setText(""+ food.getHarga());
                tfDeskripsi.setText(food.getDeskripsi());
                menuUtamaLabel.setText("");
        }
        else{
            menuUtamaLabel.setText("Baris yang anda tekan tidak memiliki data");
        }

    }
    
    @FXML
    public void logOutAction(ActionEvent event){
        moveScene("/Viewer/LoginFXML.fxml", btnLogOut);
    }
    
    public ObservableList <FoodList> getFoodList(){
        ObservableList <FoodList> foodList = FXCollections.observableArrayList();
        DBConnection connectNow = new DBConnection();
        Connection conn = connectNow.getConnection();
        String query  = "SELECT * FROM product";
        Statement st;
        ResultSet rs;
        try{
             st = conn.createStatement();
             rs = st.executeQuery(query);
             FoodList foodlist;
             while(rs.next()){
                foodlist = new FoodList(rs.getInt("idproduct"), rs.getString("NamaProduk"),
                        rs.getInt("Harga"), rs.getString("Deskripsi"));
                foodList.add(foodlist);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return foodList;
    }
    
    public void showFood(){
        ObservableList<FoodList> list = getFoodList();
        
        colId.setCellValueFactory(new PropertyValueFactory <FoodList, Integer>("id"));
        colNamaProduk.setCellValueFactory(new PropertyValueFactory <FoodList, String>("NamaProduk"));
        colHarga.setCellValueFactory(new PropertyValueFactory <FoodList, Integer>("Harga"));
        colDeskripsi.setCellValueFactory(new PropertyValueFactory <FoodList, String>("Deskripsi"));
    
        tvFoodList.setItems(list);
    }
    
    private void executeQuery(String query) {
        DBConnection connectNow = new DBConnection();
        Connection conn = connectNow.getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    // Insert data
    private void addRecord(){
        if((tfId.getText().isBlank()== false && tfNamaProduk.getText().isBlank()==false) && tfHarga.getText().isBlank()== false){
            String query = "INSERT INTO product VALUES ("+ tfId.getText() + ",'" + tfNamaProduk.getText() + "'," + tfHarga.getText() 
                        + ",'" + tfDeskripsi.getText() + "')";
            executeQuery(query);
            showFood(); }
        else{
            menuUtamaLabel.setText("Isi data yang kosong");
        }
    }
    
    //Update data
    private void updateRecord(){
        if((tfId.getText().isBlank()== false && tfNamaProduk.getText().isBlank()==false) && tfHarga.getText().isBlank()== false){
            String query = "UPDATE product SET Harga = "+ tfHarga.getText() +", NamaProduk = '" + tfNamaProduk.getText() + "', Deskripsi = '" + tfDeskripsi.getText() + "' WHERE idproduct = "+tfId.getText()+"";
            executeQuery(query);
            showFood(); }
        else{
            menuUtamaLabel.setText("Isi/Pilih data yang akan di-update");
        }
    }
    
    //Remove data
    private void removeRecord(){
        if((tfId.getText().isBlank()== false && tfNamaProduk.getText().isBlank()==false) && tfHarga.getText().isBlank()== false){
            String query =  "DELETE FROM product WHERE idproduct = "+ tfId.getText() +"";
            executeQuery(query);
            showFood();}
        else{
            menuUtamaLabel.setText("Isi/Pilih data yang akan di-dihapus");
        }
    }
    
}
