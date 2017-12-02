package rodrigodavy.com.github.jogadavelha;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Velha velha = new Velha();
    private int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tb = (TextView) findViewById(R.id.textView0);
        TextView tv = (TextView) findViewById(R.id.textView1);

        tv.setText(Character.toString(velha.getVez()));
        color = tb.getCurrentTextColor();
    }

    public void mostraVitoria(int pos,char vencedor) {
        ImageButton b[][] = new ImageButton[3][3];

        b[0][0] = (ImageButton) findViewById(R.id.b00);
        b[0][1] = (ImageButton) findViewById(R.id.b01);
        b[0][2] = (ImageButton) findViewById(R.id.b02);
        b[1][0] = (ImageButton) findViewById(R.id.b10);
        b[1][1] = (ImageButton) findViewById(R.id.b11);
        b[1][2] = (ImageButton) findViewById(R.id.b12);
        b[2][0] = (ImageButton) findViewById(R.id.b20);
        b[2][1] = (ImageButton) findViewById(R.id.b21);
        b[2][2] = (ImageButton) findViewById(R.id.b22);

        int imageResource;

        if(vencedor=='X') {
            imageResource = R.drawable.xis_vitoria;
        }else{
            imageResource = R.drawable.circulo_vitoria;
        }

        switch(pos) {
            case 1:
                b[0][0].setImageResource(imageResource);
                b[0][1].setImageResource(imageResource);
                b[0][2].setImageResource(imageResource);
                break;
            case 2:
                b[1][0].setImageResource(imageResource);
                b[1][1].setImageResource(imageResource);
                b[1][2].setImageResource(imageResource);
                break;
            case 3:
                b[2][0].setImageResource(imageResource);
                b[2][1].setImageResource(imageResource);
                b[2][2].setImageResource(imageResource);
                break;
            case 4:
                b[0][0].setImageResource(imageResource);
                b[1][0].setImageResource(imageResource);
                b[2][0].setImageResource(imageResource);
                break;
            case 5:
                b[0][1].setImageResource(imageResource);
                b[1][1].setImageResource(imageResource);
                b[2][1].setImageResource(imageResource);
                break;
            case 6:
                b[0][2].setImageResource(imageResource);
                b[1][2].setImageResource(imageResource);
                b[2][2].setImageResource(imageResource);
                break;
            case 7:
                b[0][0].setImageResource(imageResource);
                b[1][1].setImageResource(imageResource);
                b[2][2].setImageResource(imageResource);
                break;
            case 8:
                b[0][2].setImageResource(imageResource);
                b[1][1].setImageResource(imageResource);
                b[2][0].setImageResource(imageResource);
                break;
            default:
                break;
        }
    }

    public void atualizaTabuleiro(int x,int y)
    {
        TextView tb = (TextView) findViewById(R.id.textView0);
        TextView tv = (TextView) findViewById(R.id.textView1);


        if(velha.getVencedor() == 'X') {
            tb.setText(getString(R.string.winner).toUpperCase());
            tb.setTextColor(Color.GREEN);
            tv.setText("X");
            mostraVitoria(velha.getPos_vencedora(),velha.getVencedor());
        }
        else if(velha.getVencedor() == 'O') {
            tb.setText(getString(R.string.winner).toUpperCase());
            tb.setTextColor(Color.GREEN);
            tv.setText("O");
            mostraVitoria(velha.getPos_vencedora(),velha.getVencedor());
        }
        else if(velha.getVencedor() == 'v') {
            tb.setText(getString(R.string.tie));
            tb.setTextColor(Color.RED);
            tv.setText(":(");
        }
        else {
            tv.setText(Character.toString(velha.getVez()));
        }
    }

    public void reiniciar(View v)
    {
        TextView tb = (TextView) findViewById(R.id.textView0);
        TextView tv = (TextView) findViewById(R.id.textView1);
        velha.reiniciar();

        ImageButton b[] = new ImageButton[9];

        b[0] = (ImageButton)findViewById(R.id.b00);
        b[1] = (ImageButton)findViewById(R.id.b01);
        b[2] = (ImageButton)findViewById(R.id.b02);
        b[3] = (ImageButton)findViewById(R.id.b10);
        b[4] = (ImageButton)findViewById(R.id.b11);
        b[5] = (ImageButton)findViewById(R.id.b12);
        b[6] = (ImageButton)findViewById(R.id.b20);
        b[7] = (ImageButton)findViewById(R.id.b21);
        b[8] = (ImageButton)findViewById(R.id.b22);

        for(int x=0;x<9;x++)
            b[x].setImageResource(R.drawable.vazio);

        tb.setText(getString(R.string.player).toUpperCase());
        tb.setTextColor(color);
        tv.setText(Character.toString(velha.getVez()));
    }

    public void zerozero(View v)
    {
        ImageButton b = (ImageButton)findViewById(R.id.b00);

        if(velha.setPos(0,0))
        {
            if(velha.getVez() == 'O')
                b.setImageResource(R.drawable.xis);

            else if(velha.getVez() == 'X')
                b.setImageResource(R.drawable.circulo);

            atualizaTabuleiro(0,0);

        }
    }

    public void zeroum(View v)
    {
        ImageButton b = (ImageButton)findViewById(R.id.b01);

        if(velha.setPos(0,1))
        {
            if(velha.getVez() == 'O')
                b.setImageResource(R.drawable.xis);

            else if(velha.getVez() == 'X')
                b.setImageResource(R.drawable.circulo);

            atualizaTabuleiro(0,1);

        }
    }

    public void zerodois(View v)
    {
        ImageButton b = (ImageButton)findViewById(R.id.b02);

        if(velha.setPos(0,2))
        {
            if(velha.getVez() == 'O')
                b.setImageResource(R.drawable.xis);

            else if(velha.getVez() == 'X')
                b.setImageResource(R.drawable.circulo);

            atualizaTabuleiro(0,2);

        }
    }

    public void umzero(View v)
    {
        ImageButton b = (ImageButton)findViewById(R.id.b10);

        if(velha.setPos(1,0))
        {
            if(velha.getVez() == 'O')
                b.setImageResource(R.drawable.xis);

            else if(velha.getVez() == 'X')
                b.setImageResource(R.drawable.circulo);

            atualizaTabuleiro(1,0);

        }
    }

    public void umum(View v)
    {
        ImageButton b = (ImageButton)findViewById(R.id.b11);

        if(velha.setPos(1,1))
        {
            if(velha.getVez() == 'O')
                b.setImageResource(R.drawable.xis);

            else if(velha.getVez() == 'X')
                b.setImageResource(R.drawable.circulo);

            atualizaTabuleiro(1,1);

        }
    }

    public void umdois(View v)
    {
        ImageButton b = (ImageButton)findViewById(R.id.b12);

        if(velha.setPos(1,2))
        {
            if(velha.getVez() == 'O')
                b.setImageResource(R.drawable.xis);

            else if(velha.getVez() == 'X')
                b.setImageResource(R.drawable.circulo);

            atualizaTabuleiro(1,2);

        }
    }

    public void doiszero(View v)
    {
        ImageButton b = (ImageButton)findViewById(R.id.b20);

        if(velha.setPos(2,0))
        {
            if(velha.getVez() == 'O')
                b.setImageResource(R.drawable.xis);

            else if(velha.getVez() == 'X')
                b.setImageResource(R.drawable.circulo);

            atualizaTabuleiro(2,0);

        }
    }

    public void doisum(View v)
    {
        ImageButton b = (ImageButton)findViewById(R.id.b21);

        if(velha.setPos(2,1))
        {
            if(velha.getVez() == 'O')
                b.setImageResource(R.drawable.xis);

            else if(velha.getVez() == 'X')
                b.setImageResource(R.drawable.circulo);

            atualizaTabuleiro(2,1);

        }
    }

    public void doisdois(View v)
    {
        ImageButton b = (ImageButton)findViewById(R.id.b22);

        if(velha.setPos(2,2))
        {
            if(velha.getVez() == 'O')
                b.setImageResource(R.drawable.xis);

            else if(velha.getVez() == 'X')
                b.setImageResource(R.drawable.circulo);

            atualizaTabuleiro(2,2);

        }
    }
}

