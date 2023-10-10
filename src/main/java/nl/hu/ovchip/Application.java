package nl.hu.ovchip;

import nl.hu.ovchip.domein.Adres;
import nl.hu.ovchip.domein.Reiziger;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.datasource.DataSourceBuilder;

public class Application {

    private final ServerRuntime cayenneRuntime;

    public static void main(String[] args) {
        Application app = new Application();

        app.insertReiziger();
    }

    private Application() {
        this.cayenneRuntime = ServerRuntime.builder()
                .addConfig("cayenne-project.xml")
                .dataSource(DataSourceBuilder.url("jdbc:postgresql://localhost/ovchip")
                        .driver(org.postgresql.Driver.class.getName())
                        .userName("postgres").password("Aartje12").pool(1, 3).build())
                .build();
    }

    private void insertReiziger() {
        ObjectContext context = cayenneRuntime.newContext();

        Reiziger sietske = context.newObject(Reiziger.class);

        sietske.setVoorletters("S");
        sietske.setAchternaam("Boers");

        context.commitChanges();
    }
}
