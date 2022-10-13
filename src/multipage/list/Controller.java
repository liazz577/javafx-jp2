package multipage.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import multipage.Main;
import multipage.Subject;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ListView<Subject> lv;

    public static ObservableList<Subject> list = FXCollections.observableArrayList();
    public static Subject editItem;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        list.add(new Subject("JP1","Java Programing 1",40));
//        list.add(new Subject("JP2","Java Programing 2",40));
        lv.setItems(list);
    }

    public void goToForm(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("/multipage/form/form.fxml"));
        Scene listScene = new Scene(listPage,800,600);

        Main.rootStage.setTitle("Thêm môn học");
        Main.rootStage.setScene(listScene);
    }

    public void edit(ActionEvent actionEvent) throws Exception{
        editItem = lv.getSelectionModel().getSelectedItem();
        if(editItem == null) return;
        Parent listPage = FXMLLoader.load(getClass().getResource("/multipage/edit/form.fxml"));
        Scene listScene = new Scene(listPage,800,600);

        Main.rootStage.setTitle("Sửa môn học");
        Main.rootStage.setScene(listScene);
    }
}
