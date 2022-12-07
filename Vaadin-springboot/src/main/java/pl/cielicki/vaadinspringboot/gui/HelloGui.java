package pl.cielicki.vaadinspringboot.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hello")
@StyleSheet("style.css")
public class HelloGui extends VerticalLayout {

    public HelloGui() {

        TextField textFieldImie = new TextField("podaj imie", "super");
        Button buttonImie = new Button("zatwierdz", new Icon(VaadinIcon.ABACUS));
        Label labelImie = new Label();


        buttonImie.addClickListener(buttonClickEvent -> {
            labelImie.setText("Hello " + textFieldImie.getValue());
            add(new Image("https://media.tenor.com/mhLPO2VldCkAAAAM/0001.gif", "niestety :("));
        });

        add(textFieldImie, buttonImie, labelImie);



    }
}
