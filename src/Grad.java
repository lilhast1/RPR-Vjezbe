public enum Grad {
    SARAJEVO("033"), TUZLA("035"), ZENICA("032"),
    MOSTAR("036"), BIHAC("037"), ORASJE("031"),
    GORAZDE("038"), TRAVNIK("030"), LIVNO("034"),
    SIROKI_BRIJEG("039"), BRCKO("049");
    public String name;
    Grad(String name) { this.name = name; }
    @Override public String toString() { return this.name; }
}

