package guru.qa;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.heroes.JsonHeroes;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class JsonParsingHw {
    @Test
    void jsonReadHeroes() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/test/resources/HW.json");
        JsonHeroes hero = mapper.readValue(file, JsonHeroes.class);

        assertThat(hero.formed).isEqualTo(2016);
        assertThat(hero.squadName).isEqualTo("Super hero squad");
        assertThat(hero.homeTown).isEqualTo("Metro City");
        assertThat(hero.secretBase).isEqualTo("Super tower");

        assertThat(hero.members.get(0).name).isEqualTo("Molecule Man");
        assertThat(hero.members.get(0).age).isEqualTo(29);

        assertThat(hero.members.get(1).name).isEqualTo("Madame Uppercut");
        assertThat(hero.members.get(1).age).isEqualTo(39);

        assertThat(hero.members.get(2).name).isEqualTo("Eternal Flame");
        assertThat(hero.members.get(2).age).isEqualTo(1000000);
    }
}
