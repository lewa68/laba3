package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Установить менеджер компоновки для вертикального расположения

        JButton task1Button = new JButton("Task 1");
        JButton task2Button = new JButton("Task 2");
        JButton task3Button = new JButton("Task 3");
        JButton task4Button = new JButton("Task 4");
        JButton task5Button = new JButton("Task 5");

        panel.add(task1Button);
        panel.add(task2Button);
        panel.add(task3Button);
        panel.add(task4Button);
        panel.add(task5Button);

        frame.add(panel);

        task1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task1();
            }
        });

        task2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task2();
            }
        });

        task3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task3();
            }
        });

        task4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task4();
            }
        });

        task5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task5();
            }
        });

        frame.setVisible(true);
    }

    public static class Button extends JButton {
        private int clickCount;

        public Button() {
            super();
            this.clickCount = 0;
            this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickCount++;
                    updateText();
                }
            });
        }
        private void updateText() {
            setText("Button was clicked " + clickCount + " times");
        }
    }

    public static class Balance {
        private int leftWeight;
        private int rightWeight;

        public Balance() {
            this.leftWeight = 0;
            this.rightWeight = 0;
        }

        public void addRight(int weight) {
            rightWeight += weight;
            result();
        }

        public void addLeft(int weight) {
            leftWeight += weight;
            result();
        }

        private String result() {
            if (leftWeight == rightWeight) {
                return "=";
            } else if (leftWeight > rightWeight) {
                return "L";
            } else {
                return "R";
            }
        }
    }

    public static class Bell {
        private boolean isDing = true;

        public String sound() {
            if (isDing) {
                isDing=false;
                return "ding";
            } else {
                isDing = true;
                return "dong";
            }
        }
    }

    public static class OddEvenSeparator {
        private List<Integer> evenNumbers = new ArrayList<>();
        private List<Integer> oddNumbers = new ArrayList<>();

        public void addNumber(int number) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }

        public void even() {
            for (int number : evenNumbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

        public void odd() {
            for (int number : oddNumbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static class Table {
        private int[][] table;
        private int rows;
        private int cols;

        public Table(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            this.table = new int[rows][cols];
        }

        public int getValue(int row, int col) {
            if(row<3 && col<3) return table[row][col];
            else{
                System.out.println("error");
                return -1;
            }
        }

        public void setValue(int row, int col, int value) {
            if(row<3 && col<3) table[row][col] = value;
        }

        public int rows() {
            return rows;
        }

        public int cols() {
            return cols;
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            for (int[] row : table) {
                for (int value : row) {
                    result.append(value).append(" ");
                }
            }
            return result.toString().strip();
        }

        public double average() {
            int sum = 0;
            int count = 0;
            for (int[] row : table) {
                for (int value : row) {
                    sum += value;
                    count++;
                }
            }
            return (double) sum / count;
        }
    }

    public static void task1() {
        JFrame frame = new JFrame("Task 1");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setLayout(new FlowLayout());

        Button button = new Button();
        button.setSize(200, 100); // Увеличить размер кнопки
        button.setText("                                                   ");
        frame.add(button);

        frame.setVisible(true);
    }

    public static void task2() {
        Balance balance = new Balance();
        double x;
        int l,r;
        x=Math.random()*10+1;
        r=(int)x;
        x=Math.random()*10+1;
        l=(int)x;
        System.out.println("r="+r+"\nl="+l);
        balance.addLeft(l);
        balance.addRight(r);
        System.out.println("Balance result: " + balance.result());
    }

    public static void task3() {
        Bell bell = new Bell();
        for(int i=0;i<4;++i) {
            System.out.println("Bell sound: " + bell.sound());
        }
    }

    public static void task4() {
        OddEvenSeparator separator = new OddEvenSeparator();
        double x;
        int l;
        for (int i=0;i<10;i++) {
            x = Math.random() * 10 + 1;
            l = (int) x;
            separator.addNumber(l);
        }
        separator.even();
        separator.odd();
    }

    public static void task5() {
        Table table = new Table(3, 3);
        table.setValue(0, 0, 1);
        table.setValue(0, 1, 2);
        table.setValue(1, 0, 3);
        table.setValue(1, 1, 4);
        table.setValue(2, 0, 5);
        table.setValue(2, 1, 6);
        System.out.println(table);
        System.out.println(table.getValue(0,1));
        System.out.println(table.rows());
        System.out.println(table.cols());
        System.out.println( table.toString());
        System.out.println("Average: " + table.average());
    }
}