import java.util.Scanner;

public class AkilliSayiAnalizSistemi {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int pozitifAdet = 0;
        int negatifAdet = 0;
        int tekAdet = 0;
        int ciftAdet = 0;
        int enBuyuk = 0;
        int enKucuk = 0;
        int toplam = 0;
        int adet = 0;
        boolean ilkSayi = true;

        System.out.println("Akilli Sayi Analiz Sistemine hosgeldiniz. Cikmak icin 0 tuslayiniz.");

        while (true) {
            System.out.println("Lutfen bir tam sayi giriniz:");
            int sayi = input.nextInt();

            if (sayi == 0) {
                break;
            }

            adet++;
            toplam = toplam + sayi;

            if (sayi > 0) {
                pozitifAdet++;
            } else if (sayi < 0) {
                negatifAdet++;
            }

            if (sayi % 2 == 0) {
                ciftAdet++;
            } else {
                tekAdet++;
            }

            if (ilkSayi) {
                enBuyuk = sayi;
                enKucuk = sayi;
                ilkSayi = false;
            } else {
                if (sayi > enBuyuk) {
                    enBuyuk = sayi;
                }
                if (sayi < enKucuk) {
                    enKucuk = sayi;
                }
            }

            int temp = sayi;
            int basamakSayisi = 0;
            if (temp == 0) {
                basamakSayisi = 1;
            } else {
                if (temp < 0) {
                    temp = -temp;
                }
                while (temp > 0) {
                    temp = temp / 10;
                    basamakSayisi++;
                }
            }

            boolean asalMi = true;
            if (sayi <= 1) {
                asalMi = false;
            } else {
                int i = 2;
                while (i < sayi) {
                    if (sayi % i == 0) {
                        asalMi = false;
                        break;
                    }
                    i++;
                }
            }

            int toplamBolen = 0;
            int bolen = 1;
            if (sayi > 0) {
                while (bolen < sayi) {
                    if (sayi % bolen == 0) {
                        toplamBolen = toplamBolen + bolen;
                    }
                    bolen++;
                }
            }
            boolean mukemmelMi = (sayi > 0 && toplamBolen == sayi);

            System.out.println("-> Basamak sayisi: " + basamakSayisi);
            if (asalMi) {
                System.out.println("-> Bu sayi ASAL bir sayidir.");
            } else {
                System.out.println("-> Bu sayi asal degildir.");
            }
            if (mukemmelMi) {
                System.out.println("-> Bu sayi MUKEMMEL bir sayidir.");
            } else {
                System.out.println("-> Bu sayi mukemmel sayi degildir.");
            }
            System.out.println("----------------------------------------");
        }

        System.out.println("========= SONUC RAPORU =========");
        if (adet == 0) {
            System.out.println("Uyari: Hic sayi girilmeden 0 tuslandi!");
        } else {
            System.out.println("Pozitif sayilarin adedi: " + pozitifAdet);
            System.out.println("Negatif sayilarin adedi: " + negatifAdet);
            System.out.println("Tek sayilarin adedi: " + tekAdet);
            System.out.println("Cift sayilarin adedi: " + ciftAdet);
            System.out.println("En buyuk sayi: " + enBuyuk);
            System.out.println("En kucuk sayi: " + enKucuk);
            System.out.println("Girilen sayilarin toplami: " + toplam);
            
            double ortalama = (double) toplam / adet;
            System.out.println("Aritmetik ortalama: " + ortalama);

            int fark = enBuyuk - enKucuk;
            System.out.println("En buyuk ve en kucuk sayi arasindaki fark: " + fark);
        }

        input.close();
    }
}
