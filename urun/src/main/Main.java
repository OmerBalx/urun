import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Urun {
    private String isim;
    private double fiyat;

    public Urun(String isim, double fiyat) {
        this.isim = isim;
        this.fiyat = fiyat;
    }

    public String getIsim() {
        return isim;
    }

    public double getFiyat() {
        return fiyat;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Urun> urunler = new ArrayList<>();
        urunler.add(new Urun("Telefon", 30000));
        urunler.add(new Urun("Bilgisayar", 45000));
        urunler.add(new Urun("Tablet", 15000));
        urunler.add(new Urun("Kulaklık", 1200));
        urunler.add(new Urun("Saat", 10000));

        double minFiyat = 1000;
        double maxFiyat = 35000;

        Map<String, Double> urunMap = urunler.stream()
            .filter(urun -> urun.getFiyat() >= minFiyat && urun.getFiyat() <= maxFiyat)
            .collect(Collectors.toMap(Urun::getIsim, Urun::getFiyat));

        for (Map.Entry<String, Double> entry : urunMap.entrySet()) {
            System.out.println("Ürün: " + entry.getKey() + ", Fiyat: " + entry.getValue());
        }
    }
}
