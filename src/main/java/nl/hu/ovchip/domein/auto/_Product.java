package nl.hu.ovchip.domein.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.List;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.property.ListProperty;
import org.apache.cayenne.exp.property.NumericProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.exp.property.StringProperty;

import nl.hu.ovchip.domein.OvChipkaartProduct;

/**
 * Class _Product was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Product extends BaseDataObject {

    private static final long serialVersionUID = 1L;

    public static final String PRODUCT_NUMMER_PK_COLUMN = "product_nummer";

    public static final StringProperty<String> BESCHRIJVING = PropertyFactory.createString("beschrijving", String.class);
    public static final StringProperty<String> NAAM = PropertyFactory.createString("naam", String.class);
    public static final NumericProperty<BigDecimal> PRIJS = PropertyFactory.createNumeric("prijs", BigDecimal.class);
    public static final ListProperty<OvChipkaartProduct> OV_CHIPKAART_PRODUCTS = PropertyFactory.createList("ovChipkaartProducts", OvChipkaartProduct.class);

    protected String beschrijving;
    protected String naam;
    protected BigDecimal prijs;

    protected Object ovChipkaartProducts;

    public void setBeschrijving(String beschrijving) {
        beforePropertyWrite("beschrijving", this.beschrijving, beschrijving);
        this.beschrijving = beschrijving;
    }

    public String getBeschrijving() {
        beforePropertyRead("beschrijving");
        return this.beschrijving;
    }

    public void setNaam(String naam) {
        beforePropertyWrite("naam", this.naam, naam);
        this.naam = naam;
    }

    public String getNaam() {
        beforePropertyRead("naam");
        return this.naam;
    }

    public void setPrijs(BigDecimal prijs) {
        beforePropertyWrite("prijs", this.prijs, prijs);
        this.prijs = prijs;
    }

    public BigDecimal getPrijs() {
        beforePropertyRead("prijs");
        return this.prijs;
    }

    public void addToOvChipkaartProducts(OvChipkaartProduct obj) {
        addToManyTarget("ovChipkaartProducts", obj, true);
    }

    public void removeFromOvChipkaartProducts(OvChipkaartProduct obj) {
        removeToManyTarget("ovChipkaartProducts", obj, true);
    }

    @SuppressWarnings("unchecked")
    public List<OvChipkaartProduct> getOvChipkaartProducts() {
        return (List<OvChipkaartProduct>)readProperty("ovChipkaartProducts");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "beschrijving":
                return this.beschrijving;
            case "naam":
                return this.naam;
            case "prijs":
                return this.prijs;
            case "ovChipkaartProducts":
                return this.ovChipkaartProducts;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "beschrijving":
                this.beschrijving = (String)val;
                break;
            case "naam":
                this.naam = (String)val;
                break;
            case "prijs":
                this.prijs = (BigDecimal)val;
                break;
            case "ovChipkaartProducts":
                this.ovChipkaartProducts = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.beschrijving);
        out.writeObject(this.naam);
        out.writeObject(this.prijs);
        out.writeObject(this.ovChipkaartProducts);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.beschrijving = (String)in.readObject();
        this.naam = (String)in.readObject();
        this.prijs = (BigDecimal)in.readObject();
        this.ovChipkaartProducts = in.readObject();
    }

}
