package Lab.Rab.LabGUI;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

    public class Lab3v2 extends JFrame {
        int[][] spiral;
        int N;
        private Button btnFile;
        private Button button1;
        private TextArea editMatrix;
        private TextArea initMatrix;
        private Label label1;
        private Label label2;
        private Label lblCol;
        private Label lblShift;
        private TextField tfCol;
        private TextField tfShift;

        public Lab3v2() {
            this.initComponents();
        }

        private void initComponents() {
            this.initMatrix = new TextArea();
            this.editMatrix = new TextArea();
            this.label1 = new Label();
            this.label2 = new Label();
            this.button1 = new Button();
            this.lblCol = new Label();
            this.lblShift = new Label();
            this.tfCol = new TextField();
            this.tfShift = new TextField();
            this.btnFile = new Button();
            this.setDefaultCloseOperation(3);
            this.label1.setText("Матрица из файла");
            this.label2.setText("Сдвинутая матрица");
            this.button1.setLabel("Сдвинуть");
            this.button1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    Lab3v2.this.button1MouseClicked(evt);
                }
            });
            this.lblCol.setText("Ширина/высота:");
            this.lblShift.setText("Сдвиг на: ");
            this.btnFile.setLabel("Загрузить матрицу");
            this.btnFile.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    Lab3v2.this.btnFileMouseClicked(evt);
                }
            });
            GroupLayout layout = new GroupLayout(this.getContentPane());
            this.getContentPane().setLayout(layout);
            layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.initMatrix, -2, 200, -2)
                .addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
                .addComponent(this.lblCol, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.tfCol, -2, 60, -2))
                .addComponent(this.btnFile, -2, -1, -2))).addComponent(this.label1, -2, -1, -2).addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.TRAILING, false).addGroup(Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(this.label2, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                .addComponent(this.button1, -2, -1, -2)).addComponent(this.editMatrix, Alignment.LEADING, -2, 200, -2))
                .addPreferredGap(ComponentPlacement.RELATED).addComponent(this.lblShift, -2, -1, -2).addGap(15, 15, 15)
                .addComponent(this.tfShift, -2, 60, -2))).addContainerGap(96, 32767)));
            layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(9, 9, 9)
                .addComponent(this.label1, -2, -1, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addComponent(this.initMatrix, -2, 162, -2).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING)
                .addComponent(this.lblCol, -2, -1, -2).addComponent(this.tfCol, -2, -1, -2)).addGap(40, 40, 40)
                .addComponent(this.btnFile, -2, -1, -2))).addPreferredGap(ComponentPlacement.RELATED, -1, 32767)
                .addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.label2, -2, -1, -2)
                .addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.editMatrix, -2, 166, -2)
                .addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.lblShift, -2, -1, -2).addComponent(this.tfShift, -2, -1, -2))))
                .addComponent(this.button1, -2, -1, -2)).addContainerGap()));
            this.pack();
        }

        private void btnFileMouseClicked(MouseEvent evt) {
            try {
                Scanner sc = new Scanner(new File("matrix.txt"));
                this.N = Integer.parseInt(this.tfCol.getText());
                this.spiral = new int[this.N][this.N];

                int i;
                int j;
                for (i = 0; i < this.N; ++i) {
                    for (j = 0; j < this.N; ++j) {
                        this.spiral[i][j] = sc.nextInt();
                    }
                }

                this.initMatrix.setText((String) null);

                for (i = 0; i < this.N; ++i) {
                    for (j = 0; j < this.N; ++j) {
                        this.initMatrix.append(this.spiral[i][j] + "    ");
                    }

                    if (i < i + 1) {
                        this.initMatrix.append("\n");
                    }
                }
            } catch (FileNotFoundException var5) {
            }

        }

        private void button1MouseClicked(MouseEvent evt) {
            int[] cur = new int[4 * (this.N - 1)];
            int[] shift = new int[4 * (this.N - 1)];
            int Step = Integer.parseInt(this.tfShift.getText());

            int i;
            for (int k = 0; k < this.N / 2; ++k) {
                int edge = this.N - 1 - k;
                int c = 0;

                for (i = k; i < edge; ++i) {
                    cur[c] = this.spiral[k][i];
                    ++c;
                }

                for (i = k; i < edge; ++i) {
                    cur[c] = this.spiral[i][edge];
                    ++c;
                }

                for (i = edge; i >= k; --i) {
                    cur[c] = this.spiral[edge][i];
                    ++c;
                }

                for (i = edge - 1; i > k; --i) {
                    cur[c] = this.spiral[i][k];
                    ++c;
                }

                for (i = 0; i < 4 * (this.N - 2 * k - 1); ++i) {
                    shift[(i + Step) % (4 * (this.N - 2 * k - 1))] = cur[i];
                }

                c = 0;

                for (i = k; i < edge; ++i) {
                    this.spiral[k][i] = shift[c];
                    ++c;
                }

                for (i = k; i < edge; ++i) {
                    this.spiral[i][edge] = shift[c];
                    ++c;
                }

                for (i = edge; i >= k; --i) {
                    this.spiral[edge][i] = shift[c];
                    ++c;
                }

                for (i = edge - 1; i > k; --i) {
                    this.spiral[i][k] = shift[c];
                    ++c;
                }
            }

            System.out.println("Сдвинутая матрица: \n");

            int j;
            for (i = 0; i < this.N; ++i) {
                for (j = 0; j < this.N; ++j) {
                    System.out.print(this.spiral[i][j] + "    ");
                }

                if (i < i + 1) {
                    System.out.println("\n");
                }
            }

            this.editMatrix.setText((String) null);

            for (i = 0; i < this.N; ++i) {
                for (j = 0; j < this.N; ++j) {
                    this.editMatrix.append(this.spiral[i][j] + "    ");
                }

                if (i < i + 1) {
                    this.editMatrix.append("\n");
                }
            }

        }

        public static void main(String[] args) {
            try {
                LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
                int var2 = var1.length;

                for (int var3 = 0; var3 < var2; ++var3) {
                    LookAndFeelInfo info = var1[var3];
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException var5) {
                Logger.getLogger(Lab3v2.class.getName()).log(Level.SEVERE, (String) null, var5);
            } catch (InstantiationException var6) {
                Logger.getLogger(Lab3v2.class.getName()).log(Level.SEVERE, (String) null, var6);
            } catch (IllegalAccessException var7) {
                Logger.getLogger(Lab3v2.class.getName()).log(Level.SEVERE, (String) null, var7);
            } catch (UnsupportedLookAndFeelException var8) {
                Logger.getLogger(Lab3v2.class.getName()).log(Level.SEVERE, (String) null, var8);
            }

            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    (new Lab3v2()).setVisible(true);
                }
            });
        }
    }