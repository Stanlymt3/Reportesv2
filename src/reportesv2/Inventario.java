package reportesv2;

import com.itextpdf.text.pdf.codec.Base64.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Inventario extends javax.swing.JFrame {

    DefaultTableModel modelo;

    public Inventario() {
        initComponents();

        setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        modelo.addColumn("Numero");
        modelo.addColumn("Categoria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio sin Iva");
        modelo.addColumn("Iva");
        modelo.addColumn("Precio con Iva");
        modelo.addColumn("Dinero Total");
        this.tblRegistros.setModel(modelo);
    }
    double iva, precioIva, dineroTotal, cantidad;
    int contador = 0, datoTabla, numeroDato, identificador, cuenta = 0, u = 0;
    String contadorS = "", ivaS, precioIvaS, dineroTotalS, dato, codigo, Tabla, nombre, cuentaS;
    boolean error = false, llave = false, buscar = false;
    ResultSet rs = null, rt = null, rn = null, ru;
    InsertarDatos insertarDato = new InsertarDatos();

    Conexion cc = new Conexion();
    Connection con = cc.getConexion();

    public void calculos() {
        double precio;
        precio = Double.parseDouble(txtPrecio.getText());
        iva = precio * 0.13;
        ivaS = iva + "";
        //calculo del precio_con_iva/unidad
        //proviene de sumar el precio sin iva + el iva
        precioIva = precio + iva;
        precioIvaS = precioIva + "";
        //Calculo del dinero Total
        //proviene de multiplicar el costo unitario * cantidad de unidades (sin iva)
        cantidad = Double.parseDouble(txtCantidad.getText());
        dineroTotal = cantidad * precio;
        dineroTotalS = dineroTotal + "";

    }

    public void setId() {
        contador = contador + 1;
        contadorS = contador + "";
        identificador = 1;
        txtBuscarId.setText(contadorS);
    }

    public void setTabla() {
        if (cmbRegistro.getSelectedIndex() == 1) {//bebidas
            Tabla = "bebidas";
        } else if (cmbRegistro.getSelectedIndex() == 2) {//abarrotes
            Tabla = "Abarrotes";
        } else if (cmbRegistro.getSelectedIndex() == 3) {//medicina
            Tabla = "Medicina";
        } else if (cmbRegistro.getSelectedIndex() == 4) {//libreria
            Tabla = "Libreria";
        } else if (cmbRegistro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "seleccione una categoria");
        }
    }

    public void setDatos() {
        codigo = txtBuscarId.getText();
        if (cmbRegistro.getSelectedIndex() == 1) {//bebidas
            Tabla = "bebidas";
            rt = insertarDato.buscar(Tabla, codigo);
        } else if (cmbRegistro.getSelectedIndex() == 2) {//abarrotes
            Tabla = "Abarrotes";
            rt = insertarDato.buscar(Tabla, codigo);
        } else if (cmbRegistro.getSelectedIndex() == 3) {//medicina
            Tabla = "Medicina";
            rt = insertarDato.buscar(Tabla, codigo);
        } else if (cmbRegistro.getSelectedIndex() == 4) {//libreria
            Tabla = "Libreria";
            rt = insertarDato.buscar(Tabla, codigo);
        } else if (cmbRegistro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "seleccione una categoria");
        }

        cmbSIDX();

    }

    public void agregar() {
        if (cuenta == 0) {
            cuenta = 1;
            cuentaS = cuenta + "";
        } else {
            cuenta = cuenta + 1;
            cuentaS = cuenta + "";
        }

        String[] datos = new String[8];
        datos[0] = cuentaS;
        datos[1] = cmbRegistro.getItemAt(cmbRegistro.getSelectedIndex());
        datos[2] = txtBuscarNombre.getText();
        datos[3] = txtBuscarCantidad.getText();
        datos[4] = txtBuscarPrecio.getText();
        datos[5] = lblIva.getText();
        datos[6] = lblPrecio.getText();
        datos[7] = lblDinero.getText();

        limpiarCampos();
        modelo.addRow(datos);
    }

    public void establecer() {
        cmbSIDX();

        String[] datos = new String[8];
        datos[0] = cuentaS;
        datos[1] = cmbRegistro.getItemAt(cmbRegistro.getSelectedIndex());
        datos[2] = txtBuscarNombre.getText();
        datos[3] = txtBuscarCantidad.getText();
        datos[4] = txtBuscarPrecio.getText();
        datos[5] = lblIva.getText();
        datos[6] = lblPrecio.getText();
        datos[7] = lblDinero.getText();
    }

    public void limpiarEliminar() {
        txtId.setText("");
        txtId.setEnabled(true);
        txtNombre.setText("");
        txtNombre.setEnabled(false);
        txtCantidad.setText("");
        txtCantidad.setEnabled(false);
        txtPrecio.setText("");
        txtPrecio.setEnabled(false);
        txtId.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        cmbTabla = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        chkBuscar = new javax.swing.JCheckBox();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        cmbRegistro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarId = new javax.swing.JTextField();
        txtBuscarNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscarCantidad = new javax.swing.JTextField();
        txtBuscarPrecio = new javax.swing.JTextField();
        btnBuscarId = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblDinero = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnAgregarTodo = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        btnClean = new javax.swing.JButton();
        btnCleanTabla = new javax.swing.JButton();
        btnInforme = new javax.swing.JButton();
        btnPrimero = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JToggleButton();
        BtnSalir2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INVENTARIO");
        setUndecorated(true);
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel1.setText("Nombre del producto:");

        txtNombre.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad:");

        txtCantidad.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel3.setText("Precio sin iva/unidad:");

        txtPrecio.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N

        btnInsertar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/disquete v2.png"))); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        cmbTabla.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        cmbTabla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar categoria", "Bebidas", "Abarrotes" }));
        cmbTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTablaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel4.setText("Id:");

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lupa.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setEnabled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        chkBuscar.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        chkBuscar.setText("Buscar");
        chkBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBuscarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/llave abierta.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/basura1.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/subir nube.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cmbTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(622, 622, 622)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(chkBuscar))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                            .addComponent(txtCantidad)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(cmbTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addComponent(chkBuscar)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("GESTION", jPanel2);

        cmbRegistro.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        cmbRegistro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Categoria", "Bebidas", "Abarrotes" }));

        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel5.setText("Id");

        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel6.setText("Nombre");

        txtBuscarId.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        txtBuscarNombre.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel7.setText("Cantidad");

        jLabel8.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel8.setText("Precio sin Iva");

        txtBuscarCantidad.setEditable(false);
        txtBuscarCantidad.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        txtBuscarPrecio.setEditable(false);
        txtBuscarPrecio.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

        btnBuscarId.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnBuscarId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/buscar.png"))); // NOI18N
        btnBuscarId.setText("Buscar");
        btnBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIdActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel9.setText("Iva");

        jLabel10.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel10.setText("Precio con Iva");

        jLabel11.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        jLabel11.setText("Dinero total");

        lblIva.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        lblIva.setText("Valor del iva");

        lblPrecio.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        lblPrecio.setText("Valor del precio con iva agregado");

        lblDinero.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        lblDinero.setText("Valor del dinero total");

        btnAgregar.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar Registro");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnAgregarTodo.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnAgregarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/AgregarTodo.png"))); // NOI18N
        btnAgregarTodo.setText("Agregar toda la categoria");
        btnAgregarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTodoActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/limpiar.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(44, 44, 44)
                        .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(37, 37, 37)
                        .addComponent(txtBuscarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(11, 11, 11)
                        .addComponent(txtBuscarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(75, 75, 75)
                        .addComponent(lblIva, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(16, 16, 16)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(28, 28, 28)
                        .addComponent(lblDinero, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(82, 82, 82)
                                .addComponent(txtBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbRegistro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarTodo)))
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarId))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(txtBuscarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtBuscarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lblIva))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(lblPrecio))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(lblDinero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("CONSULTA", jPanel3);

        tblRegistros.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Categoria", "Nombre ", "Cantidad", "Precio sin iva", "Iva", "Precio con iva", "Dinero total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRegistros);

        btnClean.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/limpiar2.png"))); // NOI18N
        btnClean.setText("Limpiar registro");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        btnCleanTabla.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnCleanTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eliminar2.png"))); // NOI18N
        btnCleanTabla.setText("Limpiar Tabla");
        btnCleanTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanTablaActionPerformed(evt);
            }
        });

        btnInforme.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/imprimir.png"))); // NOI18N
        btnInforme.setText("Imprimir Informe");
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });

        btnPrimero.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnPrimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/primero.png"))); // NOI18N
        btnPrimero.setText("Ir al primero");
        btnPrimero.setMaximumSize(new java.awt.Dimension(107, 36));
        btnPrimero.setMinimumSize(new java.awt.Dimension(107, 36));
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Atras.png"))); // NOI18N
        btnAtras.setText("  Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnSiguiente.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/siguiente.png"))); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setMaximumSize(new java.awt.Dimension(107, 36));
        btnSiguiente.setMinimumSize(new java.awt.Dimension(107, 36));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnUltimo.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ultimo.png"))); // NOI18N
        btnUltimo.setText("Ir al ultimo");
        btnUltimo.setMaximumSize(new java.awt.Dimension(107, 36));
        btnUltimo.setMinimumSize(new java.awt.Dimension(107, 36));
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        BtnSalir2.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        BtnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salida.png"))); // NOI18N
        BtnSalir2.setText("Salir");
        BtnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalir2ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnClean)
                        .addGap(52, 52, 52)
                        .addComponent(btnCleanTabla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInforme)
                        .addGap(63, 63, 63)
                        .addComponent(BtnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUltimo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnClean, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCleanTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInforme, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnSalir2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(31, 31, 31))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        if (txtNombre.getText().isEmpty() || txtCantidad.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan campos por llenar", "ERROR DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
        } else {
            calculos();
            //Obtener la informacion de la tabla a la cual insertar los datos e insertar los datos
            if (cmbTabla.getSelectedIndex() == 1) { //bebidas
                insertarDato.insertarBebida(contadorS, txtNombre.getText(), txtCantidad.getText(), txtPrecio.getText(), ivaS, precioIvaS, dineroTotalS);
                datosINS();
            } else if (cmbTabla.getSelectedIndex() == 2) { // abarroteria
                insertarDato.insertarAbarrote(contadorS, txtNombre.getText(), txtCantidad.getText(), txtPrecio.getText(), ivaS, precioIvaS, dineroTotalS);
                datosINS();
            } else if (cmbTabla.getSelectedIndex() == 0) { //opcion default
                JOptionPane.showMessageDialog(null, "Favor seleccione una categoria", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
                error = true;
            }
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void cmbTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTablaActionPerformed
        if (buscar == false) {
            if (cmbTabla.getSelectedIndex() == 1) { //opcion bebidas
                try {
                    rs = insertarDato.contarRegistrosBebidas();
                    while (rs.next()) {
                        contador = rs.getInt(1);
                        if (contador != 0) {
                            contador = rs.getInt(1) + 1;
                            contadorS = contador + "";
                            txtId.setText(contadorS);
                        } else {
                            contador = 1;
                            contadorS = contador + "";
                            txtId.setText(contadorS);
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(), "AVISO DEL SISTEMA", 0);
                }
            } else if (cmbTabla.getSelectedIndex() == 2) { //opcion abarrotes
                try {
                    rs = insertarDato.contarRegistrosAbarrotes();
                    while (rs.next()) {
                        contador = rs.getInt(1);
                        if (contador != 0) {
                            contador = rs.getInt(1) + 1;
                            contadorS = contador + "";
                            txtId.setText(contadorS);
                        } else {
                            contador = 1;
                            contadorS = contador + "";
                            txtId.setText(contadorS);
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e.getMessage(), "AVISO DEL SISTEMA", 0);
                }
            }
            if (error == false) {
                txtNombre.setText("");
                txtCantidad.setText("");
                txtPrecio.setText("");
                txtNombre.requestFocus();
            }
        }


    }//GEN-LAST:event_cmbTablaActionPerformed


    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        txtBuscarId.setEditable(true);
        codigo = txtId.getText();
        if (cmbTabla.getSelectedIndex() == 1) {//bebidas
            Tabla = "bebidas";
            rt = insertarDato.buscar(Tabla, codigo);
        } else if (cmbTabla.getSelectedIndex() == 2) {//abarrotes
            Tabla = "Abarrotes";
            rt = insertarDato.buscar(Tabla, codigo);
        } else if (cmbTabla.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Favor seleccione una categoria", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        }

        if (rt != null) {
            try {
                while (rt.next()) {
                    if (cmbTabla.getSelectedIndex() != 0) {
                        this.txtNombre.setText(rt.getString(2));
                        this.txtCantidad.setText(rt.getString(3));
                        this.txtPrecio.setText(rt.getString(4));
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR DEL SISTEMA " + e);
            }
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void chkBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBuscarActionPerformed
        if (chkBuscar.isSelected()) {
            cmbTabla.setSelectedIndex(0);
            txtId.setEditable(true);
            txtId.setText("");
            txtId.requestFocus();
            btnBuscar.setEnabled(true);
            txtNombre.setEditable(false);
            txtCantidad.setEditable(false);
            txtPrecio.setEditable(false);
            btnInsertar.setEnabled(false);
            btnModificar.setEnabled(true);
            btnActualizar.setEnabled(true);
            btnEliminar.setEnabled(true);
            buscar = true;
        } else {
            cmbTabla.setSelectedIndex(0);
            txtNombre.requestFocus();
            txtId.setEditable(false);
            btnBuscar.setEnabled(false);
            txtNombre.setEditable(true);
            txtCantidad.setEditable(true);
            txtPrecio.setEditable(true);
            btnInsertar.setEnabled(true);
            btnModificar.setEnabled(false);
            btnActualizar.setEnabled(false);
            btnEliminar.setEnabled(false);

            buscar = false;
        }
    }//GEN-LAST:event_chkBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        txtId.setEditable(true);
        txtNombre.setEditable(true);
        txtCantidad.setEditable(true);
        txtPrecio.setEditable(true);
        txtNombre.requestFocus();
         

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty() || txtCantidad.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);

        } else {
            if (cmbTabla.getSelectedIndex() == 1) {//bebidas
                Tabla = "bebidas";
                calculos();
                codigo = txtId.getText();
                insertarDMod();
            } else if (cmbTabla.getSelectedIndex() == 2) {//abarrotes
                Tabla = "Abarrotes";
                calculos();
                codigo=txtId.getText();
                insertarDMod();
            }
        }
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!txtId.getText().isEmpty()) {
            codigo = this.txtId.getText();
            if (cmbTabla.getSelectedIndex() == 1) {//bebidas
                if (JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el dato?") == 0) {
                    Tabla = "bebidas";
                    eliminarTblYCDG();
                    limpiarEliminar();
                }
            } else if (cmbTabla.getSelectedIndex() == 2) {//abarrotes
                if (JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el dato?") == 0) {
                    Tabla = "Abarrotes";
                    eliminarTblYCDG();
                    limpiarEliminar();
                }
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCleanTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanTablaActionPerformed
        try {
            int filas = tblRegistros.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }//GEN-LAST:event_btnCleanTablaActionPerformed

    private void btnBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIdActionPerformed
        codigo = txtBuscarId.getText();
        if (cmbRegistro.getSelectedIndex() == 1) {//bebidas
            Tabla = "bebidas";
            rt = insertarDato.buscar(Tabla, codigo);
        } else if (cmbRegistro.getSelectedIndex() == 2) {//abarrotes
            Tabla = "Abarrotes";
            rt = insertarDato.buscar(Tabla, codigo);
        } else if (cmbRegistro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "seleccione una categoria");
        }

        if (rt != null) {
            try {
                while (rt.next()) {
                    if (cmbRegistro.getSelectedIndex() != 0) {
                        this.txtBuscarNombre.setText(rt.getString(2));
                        this.txtBuscarCantidad.setText(rt.getString(3));
                        this.txtBuscarPrecio.setText(rt.getString(4));
                        this.lblIva.setText(rt.getString(5));
                        this.lblPrecio.setText(rt.getString(6));
                        this.lblDinero.setText(rt.getString(7));
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR DEL SISTEMA " + e);
            }
        }

    }//GEN-LAST:event_btnBuscarIdActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cmbRegistro.setSelectedIndex(0);
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtBuscarCantidad.getText().isEmpty() || cmbRegistro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese el Id a buscar", "ERROR DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
        } else {
            agregar();
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTodoActionPerformed

        if (cmbRegistro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione la categoria", "ERROR DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
        } else {
            setTabla();
            ru = insertarDato.buscarNoE(Tabla);
            try {
                while (ru.next()) {
                    String[] datos = new String[8];
                    datos[0] = ru.getString(1);
                    datos[1] = Tabla;
                    datos[2] = ru.getString(2);
                    datos[3] = ru.getString(3);
                    datos[4] = ru.getString(4);
                    datos[5] = ru.getString(5);
                    datos[6] = ru.getString(6);
                    datos[7] = ru.getString(7);
                    modelo.addRow(datos);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR DEL SISTEMA " + ex);
            }
        }
    }//GEN-LAST:event_btnAgregarTodoActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        int lugar;
        lugar = tblRegistros.getSelectedRow();
        lugar = lugar + 1;
        tblRegistros.changeSelection(lugar, lugar, false, false);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        int lugar;
        lugar = tblRegistros.getSelectedRow();
        lugar = lugar - 1;
        tblRegistros.changeSelection(lugar, lugar, false, false);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        tblRegistros.changeSelection(0, 0, false, false);
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        int lugar;
        lugar = tblRegistros.getRowCount();
        lugar = lugar - 1;
        tblRegistros.changeSelection(lugar, lugar, false, false);
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        if (tblRegistros.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "La tabla esta vacia", "ERROR DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultTableModel dtm = (DefaultTableModel) tblRegistros.getModel();
            dtm.removeRow(tblRegistros.getSelectedRow());
        }

    }//GEN-LAST:event_btnCleanActionPerformed
    public void limpiarCampos() {
        txtBuscarId.setText(" ");
        txtBuscarNombre.setText(" ");
        txtBuscarCantidad.setText(" ");
        txtBuscarPrecio.setText(" ");
        lblDinero.setText(" ");
        lblIva.setText(" ");
        lblPrecio.setText(" ");
    }
    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
        try {
            InputStream archivo = (InputStream) getClass().getResourceAsStream("informes/infBebidas.jrxml");
            JasperDesign dise = JRXmlLoader.load(archivo);
            JasperReport jr = JasperCompileManager.compileReport(dise);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JasperViewer.viewReport(jp);
            JOptionPane.showMessageDialog(null, "Funca");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO Funca " + e);
        }
    }//GEN-LAST:event_btnInformeActionPerformed

    private void txtCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyPressed

    }//GEN-LAST:event_txtCantidadKeyPressed

    private void BtnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalir2ActionPerformed
        this.dispose();;
    }//GEN-LAST:event_BtnSalir2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    public void datosINS() {
        JOptionPane.showMessageDialog(null, "Dato insertado con exito");
        error = false;
        txtNombre.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtNombre.requestFocus();
        int id = Integer.parseInt(txtId.getText()) + 1;
        txtId.setText(id + "");
    }

    public void insertarDMod() {
        insertarDato.modificar(Tabla, this.txtId.getText(), this.txtNombre.getText(), this.txtCantidad.getText(), this.txtPrecio.getText(), ivaS, precioIvaS, dineroTotalS, codigo);
        JOptionPane.showMessageDialog(null, "Dato actualizado con exito", "MENSAJE DE INFORMACION", JOptionPane.INFORMATION_MESSAGE);
    }

    public void cmbSIDX() {
        if (rt != null) {
            try {
                while (rt.next()) {
                    if (cmbRegistro.getSelectedIndex() != 0) {
                        this.txtBuscarNombre.setText(rt.getString(2));
                        this.txtBuscarCantidad.setText(rt.getString(3));
                        this.txtBuscarPrecio.setText(rt.getString(4));
                        this.lblIva.setText(rt.getString(5));
                        this.lblPrecio.setText(rt.getString(6));
                        this.lblDinero.setText(rt.getString(7));
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR DEL SISTEMA " + e);
            }
        }

    }

    public void eliminarTblYCDG() {
        insertarDato.eliminar(Tabla, codigo);
        JOptionPane.showMessageDialog(null, "Registro eliminado de forma exitosa", "MENSAJE DE INFORMACION", JOptionPane.INFORMATION_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSalir2;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarTodo;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarId;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnCleanTabla;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInforme;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JToggleButton btnUltimo;
    private javax.swing.JCheckBox chkBuscar;
    private javax.swing.JComboBox<String> cmbRegistro;
    private javax.swing.JComboBox<String> cmbTabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDinero;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JTable tblRegistros;
    private javax.swing.JTextField txtBuscarCantidad;
    private javax.swing.JTextField txtBuscarId;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtBuscarPrecio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
