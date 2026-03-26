package ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefonoMovilTest {
    private static TelefonoMovil telefono = new TelefonoMovil("123456789");

    Contacto Daniela = new Contacto("Daniela","111111111");
    Contacto Oscar = new Contacto("Oscar","222222222");
    Contacto Miguel_a =new Contacto("M.Angel","333333333");
    Contacto Lucas = new Contacto("Lucas","444444444");

    @Test
    void testAddNewContact(){
        //todos los contactos introducidos
    telefono.addNewContact(Lucas);
    telefono.addNewContact(Daniela);
    telefono.addNewContact(Miguel_a);
    telefono.addNewContact(Oscar);
        //Espero que todos sean falsos, no se pueden volver a añadir
    assertFalse(telefono.addNewContact(Lucas));
    assertFalse(telefono.addNewContact(Daniela));
    assertFalse(telefono.addNewContact(Miguel_a));
    assertFalse(telefono.addNewContact(Oscar));

    }
    @Test
    void testUpdateContact() {
        telefono.addNewContact(Lucas);
        telefono.addNewContact(Daniela);
        telefono.addNewContact(Miguel_a);
        telefono.addNewContact(Oscar);
        //Contactos que no estan en el array
        Contacto LucasNuevo    = new Contacto("Lucas",      "999999999");
        Contacto DanielaNew    = new Contacto("DanielaNew", "555555555");
        Contacto MiguelNuevo   = new Contacto("M.Angel",    "777777777");
        Contacto Fantasma      = new Contacto("Fantasma",   "000000000");
        Contacto Cualquiera    = new Contacto("Cualquiera", "888888888");
        Contacto Lucas2 = new Contacto("Lucas", "666666666");
        // Actualizaciones válidas
        assertTrue(telefono.updateContact(Lucas,    LucasNuevo));
        assertTrue(telefono.updateContact(Daniela,  DanielaNew));
        assertTrue(telefono.updateContact(Miguel_a, MiguelNuevo));

        //El contacto antiguo no existe en la agenda
        assertFalse(telefono.updateContact(Fantasma, Cualquiera));

        //El nuevo nombre ya existe en la agenda
        assertFalse(telefono.updateContact(Oscar, Lucas2));
    }

    @Test
    void testRemoveContact() {
            telefono.addNewContact(Lucas);
            telefono.addNewContact(Daniela);
            telefono.addNewContact(Miguel_a);
            telefono.addNewContact(Oscar);

            //Contacto eliminado
            assertTrue(telefono.removeContact(Lucas));
            assertTrue(telefono.removeContact(Daniela));
            assertTrue(telefono.removeContact(Miguel_a));
            assertTrue(telefono.removeContact(Oscar));

            //El contacto no existe en la agenda
            assertFalse(telefono.removeContact(new Contacto("Fantasma", "000000000")));
    }
    @Test
    void testQueryContact() {
        telefono.addNewContact(Lucas);
        telefono.addNewContact(Daniela);
        telefono.addNewContact(Miguel_a);
        telefono.addNewContact(Oscar);
        Contacto fantasma= (new Contacto("Fantasma", "000000000"));

        //Contactos que si que existen en la agenda
        assertEquals(Lucas,telefono.queryContact("Lucas"));
        assertEquals(Daniela,telefono.queryContact("Daniela"));
        assertEquals(Miguel_a,telefono.queryContact("M.Angel"));
        assertEquals(Oscar,telefono.queryContact("Oscar"));

        // Contactos que no estan(devuelve null)
        assertNull(telefono.queryContact("Fantasma"));
    }

}