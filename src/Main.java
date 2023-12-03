import Es1.Dependente;

import static Es1.Dependente.calcolaPaga;

public class Main {
    public static void main(String[] args) {

        double stipendio = 0;
        for (int i = 0; i < 4; i++) {
            Dependente dep;
            if(i < 2) {
                dep = new Dependente("operaio","produzione");
                dep.stampaDatiDipendente();
                if(i == 0) {
                    dep.promuovi();
                }
            } else if (2 < i && i < 4) {
                dep = new Dependente("impiegato","amministrazione");
                dep.stampaDatiDipendente();
                dep.promuovi();
            } else {
                dep = new Dependente("dirigente","vendita");
                dep.stampaDatiDipendente();
            }
            calcolaPaga(dep, 5);
            stipendio += dep.getStipendio();
        }

        System.out.println("somma stipendio totale: " + stipendio);

    }
}