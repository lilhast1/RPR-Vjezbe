package ETF.imenik;

public enum Grad {
    TRAVNIK("030"), ORASJE("031"), ZENICA("032"),
    SARAJEVO("033"), LIVNO("034"), TUZLA("035"),
    MOSTAR("036"), BIHAC("037"), GORAZDE("038"),
    SIROKI_BRIJEG("039"), BRCKO("049");
    public String name;
    Grad(String name) { this.name = name; }
    @Override public String toString() { return this.name; }
}

