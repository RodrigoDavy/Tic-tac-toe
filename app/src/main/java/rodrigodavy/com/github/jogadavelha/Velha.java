package rodrigodavy.com.github.jogadavelha;

/**
 * Created by rodrigo on 23/11/17.
 */

import android.util.Log;

import java.util.Random;

public class Velha {

    private char tabuleiro[][];
    private char vez;
    private char vencedor;

    private int pos_vencedora = 0;

    public char getPos(int x,int y)
    {
        return tabuleiro[x][y];
    }

    public boolean setPos(int x,int y)
    {
        if(tabuleiro[x][y]!=' ')
            return false;

        if(vencedor != 'n')
            return false;

        tabuleiro[x][y] = vez;

        if(vez == 'X')
            vez = 'O';
        else
            vez = 'X';

        vencedor = fimDoJogo();

        return true;
    }

    public char getVez()
    {
        return vez;
    }

    public char getVencedor()
    {
        return vencedor;
    }

    private char fimDoJogo() //Retorna X = jogador "X" vence, O = jogador "O" vence, v = velha, n = nulo
    {
        for(int x=0;x<3;x++)
        {
            if(tabuleiro[x][0]!=' ')
                if(tabuleiro[x][0]==tabuleiro[x][1] && tabuleiro[x][1]==tabuleiro[x][2]) {
                    pos_vencedora = x + 1; //x -> 1 a 3
                    return tabuleiro[x][0];
                }

            if(tabuleiro[0][x]!=' ')
                if(tabuleiro[0][x]==tabuleiro[1][x] && tabuleiro[1][x]==tabuleiro[2][x]) {
                    pos_vencedora = x + 4; //x -> 4 a 6
                    return tabuleiro[0][x];
                }
        }

        if(tabuleiro[0][0]!=' ')
            if(tabuleiro[0][0]==tabuleiro[1][1] && tabuleiro[1][1]==tabuleiro[2][2]) {
                pos_vencedora = 7;
                return tabuleiro[0][0];
            }

        if(tabuleiro[0][2]!=' ')
            if(tabuleiro[0][2]==tabuleiro[1][1] && tabuleiro[1][1]==tabuleiro[2][0]) {
                pos_vencedora = 8;
                return tabuleiro[0][2];
            }

        for(int x=0;x<3;x++)
            for(int y=0;y<3;y++)
                if(tabuleiro[x][y] == ' ')
                    return 'n';

        return 'v';
    }

    public Velha()
    {
        Random r = new Random();

        tabuleiro = new char[3][3];
        vencedor = 'n';
        pos_vencedora = 0;

        if(r.nextInt(2) == 0)
            vez = 'X';
        else
            vez = 'O';

        for(int x=0;x<3;x++)
            for(int y=0;y<3;y++)
                tabuleiro[x][y] = ' ';
    }

    public void reiniciar()
    {
        Random r = new Random();

        vencedor = 'n';
        pos_vencedora = 0;

        if(r.nextInt(2) == 0)
            vez = 'X';
        else
            vez = 'O';

        for(int x=0;x<3;x++)
            for(int y=0;y<3;y++)
                tabuleiro[x][y] = ' ';
    }

    public int getPos_vencedora() {
        return pos_vencedora;
    }
}