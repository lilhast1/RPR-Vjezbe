package ETF.imenik;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ImenikMockTest {
    @Test
    void izGradaBrojeviThrows() {
        var imenik = new ImenikMock();
        imenik.dodaj("Azra", "033/710-000");
        imenik.dodaj("Mirza", "033/111-111");
        imenik.dodaj("Maja", "036/222-222");
        imenik.dodaj("Zdravko Maminjo Mamic", "036/333-333");
        assertThrows(BijelaKuga.class, () -> imenik.izGradaBrojevi(Grad.BRCKO));
    }
}