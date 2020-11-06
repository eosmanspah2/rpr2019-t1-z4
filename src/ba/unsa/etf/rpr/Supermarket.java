package ba.unsa.etf.rpr;
public class Supermarket{
    private Artikl[] artikli=new Artikl[1000];
    private int broj=0;
    public boolean dodajArtikl(Artikl artikl){
        if(broj<50){
            artikli[broj]=new Artikl(artikl.getNaziv(), artikl.getCijena(), artikl.getKod());
            broj++;
            return true;
        }
        return false;
    }
    public Artikl[] getArtikli(){
        return artikli;
    }
    private void pomjerajArtikle(int mjesto){
        for(int i=mjesto; i<broj; i++){
            artikli[i]=artikli[i+1];
        }
        artikli[broj]=null;
        broj=broj-1;
    }
    public int dajUkupnuCijenuArtikala(){
        int ukupnaCijena=0;
        for(int i=0; i<broj; i++){
            ukupnaCijena=ukupnaCijena+artikli[i].getCijena();
        }
        return ukupnaCijena;
    }
    public Artikl izbaciArtiklSaKodom(String kod){
        for(int i=0; i<broj; i++){
            if(artikli[i].getKod().equals(kod)){
                Artikl ubaceni=new Artikl(artikli[i].getNaziv(), artikli[i].getCijena(), artikli[i].getKod());
                artikli[i]=null;
                pomjerajArtikle(i);
                return ubaceni;
            }
        }
        return null;
    }
}
