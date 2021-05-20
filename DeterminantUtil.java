package com.company;


public class DeterminantUtil
{
    public static double determinant(int n, double [][] array) {

//----------------------------------------------------------------------------------------

//объявление переменных-------------------------------------------------------------------
        double opredelitel = 0, chislitel = 1, znamenatel = 1;
        double [] promezh_array = new double[n];
        int stepen = n - 1;

//Правило прямоугольника-----------------------------------------------------------------
        int a = 0, b = 0;

        while((a < n) && (b < n))
        {
            int r = a, s = b, str = a + 1, str2 = a + 1, stolb = b + 1;

//Устранение нуля------------------------------

            while((array[a][b] == 0) && (str < n))
            {
                for(int x = r; x < n; x ++)
                    promezh_array[x] = array[r][x];

                for(int x = r; x < n; x ++)
                    array[r][x] = array[str][x];

                for(int x = r; x < n; x ++)
                    array[str][x] = promezh_array[x];

                str = str + 1;
            }

//Преобразовываем матрицу по правилу прямоугольника

            while((stolb < n))
            {
                while(str2 < n)
                {
                    array[str2][stolb] = array[a][b] * array[str2][stolb] -
                            array[a][stolb] * array[str2][b];

                    str2 = str2 + 1;
                }
                stolb = stolb + 1;
                str2 = a + 1;
            }

            for(int i = a + 1; i < n; i ++)
                array[i][b] = 0;

//находим знаменатель
            if ((a < n - 1) && (b < n - 1))
                znamenatel = znamenatel * Math.pow(array[a][b], stepen);
//--------------------------------------------------------

            stepen = stepen - 1;

            a = a + 1;
            b = b + 1;

        }
//-------------------------------------------------------------------------------------

//находим числитель
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++)
                if(i == j) chislitel = chislitel * array[i][j];
//-------------------------------------------------

//определитель матрицы
        opredelitel = chislitel / znamenatel;
//-----------------------------------


//вывод определителя
        System.out.println("Determinant = "+opredelitel);
//-------------------------------
        return opredelitel;
    }
}