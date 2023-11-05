public class FiksniBroj extends TelefonskiBroj {
    private String grad;
    private String broj;
    public FiksniBroj(Grad grad, String broj) {
        this.grad = grad.toString();
        this.broj = broj;
    }
    @Override
    public String ispisi() {
        StringBuilder s = new StringBuilder(grad);
        s.append("/" + broj);
        return s.toString();
    }
}
