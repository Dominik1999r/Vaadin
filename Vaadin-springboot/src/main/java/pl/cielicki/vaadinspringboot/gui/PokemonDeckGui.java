package pl.cielicki.vaadinspringboot.gui;


import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.cielicki.vaadinspringboot.PokemonDeck;
import pl.cielicki.vaadinspringboot.model.Pokemon;
import pl.cielicki.vaadinspringboot.model.PokemonType;

import java.util.List;
import java.util.stream.Collectors;

@Route
public class PokemonDeckGui extends VerticalLayout {

    @Autowired
    public PokemonDeckGui(PokemonDeck pokemonDeck) {

        ComboBox<PokemonType> pokemonTypeComboBox = new ComboBox<>("Pokemon Type", PokemonType.values());

        pokemonTypeComboBox.addValueChangeListener(click -> {
            removeAll();

            List<Pokemon> pokemonList = pokemonDeck.getPokemons();
            List<Pokemon> collect = pokemonList.stream().
                    filter(pokemon -> pokemon.getPokemonType() == pokemonTypeComboBox.getValue()).
                    collect(Collectors.toList());

            Grid <Pokemon> grid = new Grid<>(Pokemon.class);
            grid.setItems(collect);
            grid.removeColumnByKey("image");
            grid.addColumn(new ComponentRenderer<>(pokemonn ->{
                Image image = new Image(pokemonn.getImage(), pokemonn.getImage());
                return image;
            })).setHeader("Image");
            add(pokemonTypeComboBox, grid);
        });

        add(pokemonTypeComboBox);

    }
}
