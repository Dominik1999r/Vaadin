package pl.cielicki.vaadinspringboot.gui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.cielicki.vaadinspringboot.PokemonDeck;
import pl.cielicki.vaadinspringboot.model.Pokemon;
import pl.cielicki.vaadinspringboot.model.PokemonType;

@Route("add")
public class PokemonAdder extends VerticalLayout {

    @Autowired
    public PokemonAdder(PokemonDeck pokemonDeck) {
        TextField textFieldName = new TextField("name");
        TextField textFieldImage = new TextField("image");
        ComboBox<PokemonType> pokemonTypeComboBox = new ComboBox<>("Pokemon Typ", PokemonType.values());

        Button buttonAdd = new Button("add new Pokemon");


        buttonAdd.addClickListener(buttonClickEvent -> {
           Pokemon pokemon = new Pokemon();
           pokemon.setName(textFieldName.getValue());
           pokemon.setImage(textFieldImage.getValue());
           pokemon.setPokemonType(pokemonTypeComboBox.getValue());
           pokemonDeck.getPokemons().add(pokemon);
            Notification notification = new Notification("Pokemon added!", 3000);
            notification.open();

        });

        add(textFieldName, textFieldImage, pokemonTypeComboBox,buttonAdd);
    }
}
