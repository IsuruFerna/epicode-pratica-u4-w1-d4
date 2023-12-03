package Es1;

import java.util.Random;
import java.util.StringJoiner;

public class Dependente {
    private double stipendioBase;
    private int marticola;
    private double stipendio;
    private double importoOrarioStraordinario;
    private Livello livello;
    private Dipartimento dipartimento;

//    constructors
     public Dependente() {
        Random rnd = new Random();
        this.marticola = rnd.nextInt(1, 10000);
        this.stipendioBase = 1000;
        this.stipendio = stipendioBase;
        this.livello = Livello.OPERAIO;
        this.importoOrarioStraordinario = 30;
     }

     public Dependente(int marticola, String dipartimento) {
         try {
             Dipartimento dip = Dipartimento.valueOf(dipartimento.toUpperCase());
             this.dipartimento = dip;
         } catch (IllegalArgumentException e) {
             System.out.println(dipartimento + "is not valid! " + e);
         }
         this.marticola = marticola;
         this.importoOrarioStraordinario = 30;
         this.livello = Livello.OPERAIO;
         this.stipendio = calcolaPaga(this);
     }

    public Dependente (String dipartimento) {
        Random rnd = new Random();
        this.marticola = rnd.nextInt(1, 10000);
        this.stipendioBase = 1000;
        this.importoOrarioStraordinario = 30;
        this.livello = Livello.OPERAIO;

        try {
            this.dipartimento = Dipartimento.valueOf(dipartimento.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println(dipartimento + "is not valid! " + e);
        }

        this.stipendio = calcolaPaga(this);
    }

     public Dependente (String livello, String dipartimento) {
         Random rnd = new Random();
         this.marticola = rnd.nextInt(1, 10000);
         this.stipendioBase = 1000;
         this.importoOrarioStraordinario = 30;

         try {
             this.livello = Livello.valueOf(livello.toUpperCase());
         } catch (IllegalArgumentException e) {
             System.out.println(livello + "is not valid! " + e);
         }

         try {
             this.dipartimento = Dipartimento.valueOf(dipartimento.toUpperCase());
         } catch (IllegalArgumentException e) {
             System.out.println(dipartimento + "is not valid! " + e);
         }

         this.stipendio = calcolaPaga(this);
     }



//    getters
    public double getStipendioBase() {
        return stipendioBase;
    }

    public int getMarticola() {
        return marticola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public double getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }

    public Livello getLivello() {
        return livello;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

//    setters
    public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
        this.importoOrarioStraordinario = importoOrarioStraordinario;
    }

    public void setDipartimento(Dipartimento dipartimento) {
        this.dipartimento = dipartimento;
    }

//    methods
    public void stampaDatiDipendente() {
        String str = new StringJoiner(", ", Dependente.class.getSimpleName() + "[", "]")
                .add("stipendioBase=" + stipendioBase)
                .add("marticola=" + marticola)
                .add("stipendio=" + stipendio)
                .add("importoOrarioStraordinario=" + importoOrarioStraordinario)
                .add("livello=" + livello)
                .add("dipartimento=" + dipartimento)
                .toString();

        System.out.println(str);
    }

    public Dependente promuovi() {

         // loop over the enum
         Livello[] livelli = Livello.values();
         for(int i = 0; i < livelli.length; i++) {
             if(this.livello.equals(livelli[i])) {

                 // check if the dipendent in the maximum level
                 if (i == livelli.length - 1) {
                     System.out.println("Dipendent è nel massimo livello!");

                 // promote if not in the maximum level
                 } else {
                     this.livello = livelli[i + 1];

                     // setta stipendio
                     if(this.livello.equals(Livello.IMPIEGATO)) {
                         this.stipendio = this.stipendioBase * 1.2;
                     } else if(this.livello.equals(Livello.QUADRO)) {
                         this.stipendio = this.stipendioBase * 1.5;
                     } else if(this.livello.equals(Livello.DIRIGENTE)) {
                         this.stipendio = stipendioBase * 2;
                     } else {
                         this.stipendio = stipendioBase;
                     }
                     System.out.println(livelli[i] + " promosso al livello " + livelli[i + 1]);
                     break;
                 }
             }
         }
         return this;
    }


    public static double calcolaPaga(Dependente dep) {
        // setta stipendio
        if(dep.livello.equals(Livello.IMPIEGATO)) {
            dep.stipendio = dep.stipendioBase * 1.2;
        } else if(dep.livello.equals(Livello.QUADRO)) {
            dep.stipendio = dep.stipendioBase * 1.5;
        } else if(dep.livello.equals(Livello.DIRIGENTE)) {
            dep.stipendio = dep.stipendioBase * 2;
        } else {
            dep.stipendio = dep.stipendioBase;
        }

        return dep.stipendio;
    }
    public static Dependente calcolaPaga(Dependente dep, double oreStraordinaro) {
        // setta stipendio
        if(dep.livello.equals(Livello.IMPIEGATO)) {
            dep.stipendio = dep.stipendioBase * 1.2;
        } else if(dep.livello.equals(Livello.QUADRO)) {
            dep.stipendio = dep.stipendioBase * 1.5;
        } else if(dep.livello.equals(Livello.DIRIGENTE)) {
            dep.stipendio = dep.stipendioBase * 2;
        } else {
            dep.stipendio = dep.stipendioBase;
        }
        dep.stipendio = dep.stipendio + (dep.importoOrarioStraordinario * oreStraordinaro);

        return dep;
    }
}
