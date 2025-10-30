package bsu.rfe.java.group10.lab3.Bozhko.varA3;

import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
// В данной модели два столбца
        return 3;
    }

    public int getRowCount() {
// Вычислить количество точек между началом и концом отрезка
// исходя из шага табулирования
        return (int) Math.ceil((to - from) / step) + 1;
    }

    public Object getValueAt(int row, int col) {
// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
        double x = from + step * row;
        Double result = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            result = result * x + coefficients[i];
        }
        switch (col) {

            case 0:
// Если запрашивается значение 1-го столбца, то это X
                return x;
            case 1: {
// Если запрашивается значение 2-го столбца, то это значение
// многочлена
                return result;

            }
          //  case 2:
               // return x;
            default:
                // Double check_result = (double)Math.round(result*100000)/100000;
               // if(check_result.toString().charAt(0) == check_result.toString().charAt(check_result.toString().length()-1))
                if(result/10 == 1)
                    return true;
                 else
                  return false;

        }
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
// Название 1-го столбца
                return "Значение X";
            case 1:
                return "Значение многочлена";
            default:
// Название 2-го столбца
                return "симмерия";
        }
    }
    public Class<?> getColumnClass(int col) {
// И в 1-ом и во 2-ом столбце находятся значения типа Double
        if(col <= 1)
            return Double.class;
        else
            return Boolean.class;
    }
}
