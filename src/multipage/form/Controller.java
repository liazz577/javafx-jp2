package multipage.form;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import multipage.Main;
import multipage.Subject;

public class Controller {
    public TextField txtCode;
    public TextField txtName;
    public TextField txtHours;

    public void goToList(ActionEvent actionEvent) throws Exception{
        Parent listPage = FXMLLoader.load(getClass().getResource("/multipage/list/list.fxml"));
        Scene listScene = new Scene(listPage,800,600);

        Main.rootStage.setTitle("Danh sách môn học");
        Main.rootStage.setScene(listScene);
    }

    public void submit(ActionEvent actionEvent) {
        try {
            int hours = Integer.parseInt(txtHours.getText());
            if(txtCode.getText().isEmpty() || txtName.getText().isEmpty()
            || hours < 0 ){
                throw new Exception("Vui lòng nhập dữ liệu");
            }
            for (Subject s: multipage.list.Controller.list){
                if(s.getCode().equals(txtCode.getText()))
                    throw new Exception("Vui lòng nhập dữ liệu");
            }
            multipage.list.Controller.list.add(new Subject(txtCode.getText(),txtName.getText(),hours));
            goToList(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
