package com.example.asus.myuts;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    TextView txtkesempatan, txtskor, txtronde;
    ImageView imgsoal;
    EditText pltisi1, pltisi2, pltisi3, pltisi4, pltisi5, pltisi6, pltisi7;
    Button btnjwb1, btnjwb2, btnjwb3, btnjwb4, btnjwb5, btnjwb6, btnjwb7, btnjwb8;
    classSoal [] cs;
    int kesempatan, jawabanke, skor, panjang, soalke, ronde;
    public classSoal img[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //img=new classSoal[20];
        //for (int j = 1; j < 6; j++) {
        //    Drawable soal = getResources().getDrawable(getResources()
        //            .getIdentifier("q"+j, "drawable", getPackageName()));
        //            img[j]= {soal};
        //}

        int image[] ={R.drawable.q1
                ,R.drawable.q2
                ,R.drawable.q3
                ,R.drawable.q4
                ,R.drawable.q5
                ,R.drawable.q6
        };

        ronde=1;
        txtronde = (TextView)findViewById(R.id.txtronde);
        txtronde.setText("Ronde : "+ String.valueOf(ronde));

        kesempatan=3;
        txtkesempatan=(TextView)findViewById(R.id.txtkesempatan);
        txtkesempatan.setText("Kesempatan: "+ String.valueOf(kesempatan));

        skor=0;
        txtskor=(TextView)findViewById(R.id.txtskor);
        txtskor.setText("Score : " + String.valueOf(skor));

        cs = new classSoal[]{
                new classSoal(1
                        , new String[]{"a", "b", "c"}
                        , new String[]{"a", "b", "c", "d", "e", "f", "g", "h"}
                        , new ImageView[0]),
                new classSoal(2
                        , new String[]{"d", "e", "f", "g"}
                        , new String[]{"d", "e", "f", "g", "h", "i", "j", "k"}
                        , new ImageView[1]),
                new classSoal(3
                        , new String[]{"d", "e", "f", "g"}
                        , new String[]{"d", "e", "f", "g", "h", "i", "j", "k"}
                        , new ImageView[2]),
                new classSoal(4
                        , new String[]{"d", "e", "f", "g"}
                        , new String[]{"d", "e", "f", "g", "h", "i", "j", "k"}
                        , new ImageView[3]),
                new classSoal(5
                        , new String[]{"d", "e", "f", "g"}
                        , new String[]{"d", "e", "f", "g", "h", "i", "j", "k"}
                        , new ImageView[4])
        };

        soalke = 0;
        loadSoal(soalke);

    }

    private void loadSoal(int soalke) {
        panjang = Array.getLength(cs[soalke].getJawaban());

        pltisi1 = (EditText) findViewById(R.id.pltisi1);
        pltisi2 = (EditText) findViewById(R.id.pltisi2);
        pltisi3 = (EditText) findViewById(R.id.pltisi3);
        pltisi4 = (EditText) findViewById(R.id.pltisi4);
        pltisi5 = (EditText) findViewById(R.id.pltisi5);
        pltisi6 = (EditText) findViewById(R.id.pltisi6);
        pltisi7 = (EditText) findViewById(R.id.pltisi7);

        EditText[] kolom = new EditText[]{
                pltisi1,
                pltisi2,
                pltisi3,
                pltisi4,
                pltisi5,
                pltisi6,
                pltisi7
        };

        for (int i = 0; i < panjang; i++) {
            kolom[i].setVisibility(View.VISIBLE);
            kolom[i].setText("");
        }

        btnjwb1 = (Button) findViewById(R.id.btnjwb1);
        btnjwb2 = (Button) findViewById(R.id.btnjwb2);
        btnjwb3 = (Button) findViewById(R.id.btnjwb3);
        btnjwb4 = (Button) findViewById(R.id.btnjwb4);
        btnjwb5 = (Button) findViewById(R.id.btnjwb5);
        btnjwb6 = (Button) findViewById(R.id.btnjwb6);
        btnjwb7 = (Button) findViewById(R.id.btnjwb7);
        btnjwb8 = (Button) findViewById(R.id.btnjwb8);

        Button[] jawab = new Button[]{
                btnjwb1,
                btnjwb2,
                btnjwb3,
                btnjwb4,
                btnjwb5,
                btnjwb6,
                btnjwb7,
                btnjwb8
        };

        String[] pilihan = cs[soalke].getPilihan();

        for (int i = 0; i < 8; i++) {
            jawab[i].setVisibility(View.VISIBLE);
            jawab[i].setText(pilihan[i]);
        }

        jawabanke = 0;
    }

    public void cekjawab(View view) {

        //ambil text dari button yang di tekan
        Button b = (Button) view;
        String dipilih = b.getText().toString();

        //tampung jawaban ke array
        String[] jawaban = cs[soalke].getJawaban();

        //cocokkan jawaban dengan text di button
        if (dipilih.equals(jawaban[jawabanke])) {

            //hilangkan button yang di klik
            b.setVisibility(View.INVISIBLE);

            //daftarkan jawaban
            pltisi1 = (EditText) findViewById(R.id.pltisi1);
            pltisi2 = (EditText) findViewById(R.id.pltisi2);
            pltisi3 = (EditText) findViewById(R.id.pltisi3);
            pltisi4 = (EditText) findViewById(R.id.pltisi4);
            pltisi5 = (EditText) findViewById(R.id.pltisi5);
            pltisi6 = (EditText) findViewById(R.id.pltisi6);
            pltisi7 = (EditText) findViewById(R.id.pltisi7);

            //tampung edittext ke array (karena ga bisa dynamic variable cth:pltisi+(i))
            EditText[] kolom = new EditText[]{
                    pltisi6,
                    pltisi4,
                    pltisi2,
                    pltisi1,
                    pltisi3,
                    pltisi5,
                    pltisi7
            };

            //looping untuk cari kotak yang kosong
            //penanda kapan whilenya bisa berhenti
            boolean kotakkosong = false;
            //counter untuk array kolom
            int counter = 0;
            //looping selama kotakkosong belum ditemukan
            while (kotakkosong == false) {
                //cek kolom ke i visible atau ndak
                boolean tampil = kolom[counter].isShown();
                if (tampil == true) {
                    //kalau visible cek lagi, tu kotak dah ada isinya belom
                    if (kolom[counter].getText().toString().equals("")) {
                        //kalau kosong, isi kotak dengan huruf yang ada di button
                        kolom[counter].setText(dipilih);
                        //kurangi jumlah huruf yang harus di jawab
                        panjang--;
                        //suruh whilenya berhenti dengan set kotak kosong menjadi true
                        kotakkosong = true;
                    } else {
                        //kalau kotaknya isi sesuatu, lanjut cek kotak berikutnya
                        counter++;
                    }
                } else {
                    //kalau kotak tersebut terhidden (ndak visible) lanjut cek kotak berikutnya
                    counter++;
                }
            }

            //mengubah untuk cek huruf berikutnya pada jawaban
            jawabanke++;
        } else {
            //membatasi pengurangan kesempatan biar ga lebih dari 0
            if (kesempatan > 1) {
                //kurangi kesempatan player
                kesempatan--;
                //daftar txtkesempatan
                txtkesempatan = (TextView) findViewById(R.id.txtkesempatan);
                //tulis di textview
                txtkesempatan.setText("KESEMPATAN : " + String.valueOf(kesempatan));
            } else {
                //kalau kesempatannya habis, maka . . ., silahkan di coding sendiri ^^
            }
        }
        //cek apakah masih ada huruf yang harus di jawab ?
        if (panjang == 0) {
            skor += 100;
            txtskor = (TextView) findViewById(R.id.txtskor);
            txtskor.setText("SKOR : " + String.valueOf(skor));

            ronde+=1;
            txtronde = (TextView)findViewById(R.id.txtronde);
            txtronde.setText("Ronde : "+String.valueOf(ronde));

            //cek apakah masih ada soal berikutnya ? dengan cara cek sekarang soal ke berapa bandingkan dengan jumlah array soal - 1
            if(soalke<cs.length-1){
                //kalau masih ada, set soalke untuk load soal berikutnya
                soalke++;
                loadSoal(soalke);
            } else {
                //kalau soal sudah habis, maka... silahkan di coding sendiri ^^
            }
        }
    }
}
