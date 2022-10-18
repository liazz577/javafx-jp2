package library.book.create;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import library.Main;
import library.helper.Connector;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class BookCreateController {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            int qty = Integer.parseInt(txtQty.getText());
            String sql_txt = "insert into books(name,author,qty) values(?,?,?)";
            // +       "values('"+name+"','"+author+"',"+qty+")";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(name);
            arr.add(author);
            arr.add(qty);
            /*
            PreparedStatement pstm = conn.getPreparedStatement(sql_txt);
            pstm.setString(1,name);
            pstm.setString(2,author);
            pstm.setInt(3,qty);

            pstm.execute();*/
            if(conn.execute(sql_txt,arr)){
                backToList();
            }else{
                System.out.println("Error");
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backToList() throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
