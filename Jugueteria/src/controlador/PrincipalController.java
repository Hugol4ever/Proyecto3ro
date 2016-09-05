
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.si301.jugueteria.commons.Globals;
import org.si301.jugueteria.core.ModuloCategoria;
import org.si301.jugueteria.core.ModuloClientes;
import org.si301.jugueteria.core.ModuloCompras;
import org.si301.jugueteria.core.ModuloEmpleados;
import org.si301.jugueteria.core.ModuloMarca;
import org.si301.jugueteria.core.ModuloPedidos;
import org.si301.jugueteria.core.ModuloPrivilegios;
import org.si301.jugueteria.core.ModuloProductos;
import org.si301.jugueteria.core.ModuloPuesto;
import org.si301.jugueteria.core.ModuloVentas;
import org.si301.jugueteria.model.Empleado;
import vista.*;

/**
 *
 * @author Hugo
 */
public class PrincipalController implements ActionListener {
    //Atributos
    private Principal principal;
    private Empleado empleado;
    private Timer reloj;

    //Metodos
    public void iniciarVista() {
        this.principal.getTxtFecha().setEditable(false);
        this.principal.getTxtHora().setEditable(false);
        this.principal.getTxtUsuario().setEditable(false);
        this.principal.getTxtUsuario().setText(this.empleado.getNombre() + " " + this.empleado.getApellidoPateno());
        this.principal.getTxtFecha().setText(Globals.DATE_FORMAT.format(new Date()));
        this.principal.setLocationRelativeTo(null);
        
        this.principal.setVisible(true);
        privilegios();
    }
    
    public void privilegios() {
        this.principal.getMniABCClientes().setEnabled(this.empleado.getPrivilegios().isABC_cliente());
        this.principal.getMniInfoClientes().setEnabled(this.empleado.getPrivilegios().isRep_cliente());
        this.principal.getMniABCEmpleados().setEnabled(this.empleado.getPrivilegios().isABC_empleado());
        this.principal.getMniInfoEmpleados().setEnabled(this.empleado.getPrivilegios().isRep_empleado());
        this.principal.getMniABCProductos().setEnabled(this.empleado.getPrivilegios().isABC_producto());
        this.principal.getMniInfoProductos().setEnabled(this.empleado.getPrivilegios().isRep_producto());
        this.principal.getMniABCVentas().setEnabled(this.empleado.getPrivilegios().isABC_venta());
        this.principal.getMniInfoVentas().setEnabled(this.empleado.getPrivilegios().isRep_venta());
        this.principal.getMniInfoCompras().setEnabled(this.empleado.getPrivilegios().isRep_compra());
        this.principal.getMniABCPedidos().setEnabled(this.empleado.getPrivilegios().isABC_pedido());
        this.principal.getMniInfoPedidos().setEnabled(this.empleado.getPrivilegios().isRep_pedido());
        this.principal.getMniABCUsuario().setEnabled(this.empleado.getPrivilegios().isAdd_user());
        this.principal.getMniABCMarcas().setEnabled(this.empleado.getPrivilegios().isAdd_marca());
        this.principal.getMniABCPuesto().setEnabled(this.empleado.getPrivilegios().isAdd_puesto());
        this.principal.getMniABCCategoria().setEnabled(this.empleado.getPrivilegios().isAdd_categoria());
        this.principal.getMniAbastecer().setEnabled(this.empleado.getPrivilegios().isAbastecer_almacen());
        this.principal.getMniInfoAlmacen().setEnabled(this.empleado.getPrivilegios().isRep_almacen());
    }
    
    public void hora(ActionEvent e) {
        this.principal.getTxtHora().setText(Globals.TIME_FORMAT.format(new Date()));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.principal.getMniABCClientes() == e.getSource()) {
            CapturaClientes capturaClientes = new CapturaClientes();
            CapturaClientesController clientesC = new CapturaClientesController(new ModuloClientes(), capturaClientes);
            clientesC.iniciarVista();
            this.principal.getDskEscritorio().add(capturaClientes);
            capturaClientes.show();
        } else if (this.principal.getMniInfoClientes() == e.getSource()) {
            InformeClientes informeClientes = new InformeClientes();
            InformeClientesController informeClientesController = new InformeClientesController(new ModuloClientes(), informeClientes);
            informeClientesController.iniciarVista();
            this.principal.getDskEscritorio().add(informeClientes);
            informeClientes.show();
        } else if (this.principal.getMniABCEmpleados() == e.getSource()) {
            CapturarEmpleados capturarEmpleados = new CapturarEmpleados();
            CapturaEmpleadosController capturaempleadosController = new CapturaEmpleadosController(new ModuloEmpleados(), capturarEmpleados);
            capturaempleadosController.iniciarVista();
            this.principal.getDskEscritorio().add(capturarEmpleados);
            capturarEmpleados.show();
        } else if (this.principal.getMniInfoEmpleados() == e.getSource()) {
            InformeEmpleados informeEmpleados = new InformeEmpleados();
            
        } else if (this.principal.getMniABCProductos() == e.getSource()) {
            CapturarProductos capturarProductos = new CapturarProductos();
            CapturaProductosController capturaProductosController = new CapturaProductosController(new ModuloProductos(), capturarProductos, new ModuloCategoria(), new ModuloMarca());
            capturaProductosController.iniciarVista();
            this.principal.getDskEscritorio().add(capturarProductos);
            capturarProductos.show();
        } else if (this.principal.getMniInfoProductos() == e.getSource()) {
            InformeProductos informeProductos = new InformeProductos();
            
        } else if (this.principal.getMniABCVentas() == e.getSource()) {
            CapturarVenta capturarVenta = new CapturarVenta();
            CapturaVentaController capturaVentaController = new CapturaVentaController(capturarVenta, new ModuloVentas(), new ModuloProductos(), new ModuloClientes(), this.empleado);
            capturaVentaController.iniciarVista();
            this.principal.getDskEscritorio().add(capturarVenta);
            capturarVenta.show();
        } else if (this.principal.getMniInfoVentas() == e.getSource()) {
            InformeVentas informeVentas = new InformeVentas();
            
        } else if (this.principal.getMniInfoCompras() == e.getSource()) {
            
        } else if (this.principal.getMniABCPedidos() == e.getSource()) {
            CapturarPedidos capturarPedidos = new CapturarPedidos();
            CapturaPedidosController capturaPedidosController = new CapturaPedidosController(capturarPedidos, new ModuloPedidos(), new ModuloClientes(), new ModuloProductos());
            capturaPedidosController.iniciarVista();
            this.principal.getDskEscritorio().add(capturarPedidos);
            capturarPedidos.show();
        } else if (this.principal.getMniInfoPedidos() == e.getSource()) {
            InformePedidos informePedidos = new InformePedidos();
            
        } else if (this.principal.getMniABCUsuario() == e.getSource()) {
            AgregarUsuario agregarUsuario = new AgregarUsuario();
            AgregarUsuarioController agregarUsuarioController = new AgregarUsuarioController(new ModuloPrivilegios(), new ModuloEmpleados(), empleado, agregarUsuario);
            agregarUsuarioController.iniciarVista();
            this.principal.getDskEscritorio().add(agregarUsuario);
            agregarUsuario.show();
        } else if (this.principal.getMniABCMarcas() == e.getSource()) {
            AgregarMarca agregarMarca = new AgregarMarca();
            AgregarMarcaController agregarMarcaController = new AgregarMarcaController(agregarMarca, new ModuloMarca());
            agregarMarcaController.iniciarVista();
            this.principal.getDskEscritorio().add(agregarMarca);
            agregarMarca.show();
        } else if (this.principal.getMniABCPuesto() == e.getSource()) {
            AgregarPuesto agregarPuesto = new AgregarPuesto();
            AgregarPuestoController agregarPuestoController = new AgregarPuestoController(agregarPuesto, new ModuloPuesto());
            agregarPuestoController.iniciarVista();
            this.principal.getDskEscritorio().add(agregarPuesto);
            agregarPuesto.show();
        } else if (this.principal.getMniABCCategoria() == e.getSource()) {
            
        } else if (this.principal.getMniAbastecer() == e.getSource()) {
            AbastecerAlmacen abastecerAlmacen = new AbastecerAlmacen();
            AbastecerAlmacenController almacenC = new AbastecerAlmacenController(new ModuloProductos(), abastecerAlmacen, new ModuloCompras(), this.empleado);
            almacenC.iniciarVista();
            this.principal.getDskEscritorio().add(abastecerAlmacen);
            abastecerAlmacen.show();
        } else if (this.principal.getMniInfoAlmacen() == e.getSource()) {
            
        } else if (this.principal.getMniSalir() == e.getSource()) {
            int desicion = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere salir del programa?", "Imagin", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == desicion) {
                System.exit(0);
            }
        } else if (this.principal.getMniCerrar() == e.getSource()) {
            int desicion = JOptionPane.showConfirmDialog(null, "¿Seguro que quiere cerrar sesión?", "Imagin", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == desicion) {
                LoginController loginController = new LoginController(new Login(), new Empleado());
                loginController.iniciarVista();
                this.principal.dispose();
            }
        } else {
            CambiarPassword cambiarPassword = new CambiarPassword();
            CambiarPasswordController cambiarPasswordController = new CambiarPasswordController(cambiarPassword, new ModuloEmpleados(), empleado);
            cambiarPasswordController.iniciarVista();
            this.principal.getDskEscritorio().add(cambiarPassword);
            cambiarPassword.show();
        }
    }

    //Constructor
    public PrincipalController(Principal principal, Empleado empleado) {
        this.principal = principal;
        this.empleado = empleado;
        
        this.reloj = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                hora(e);
            }
        });
        this.reloj.start();
        
        this.principal.getMniABCClientes().addActionListener(this);
        this.principal.getMniInfoClientes().addActionListener(this);
        this.principal.getMniABCEmpleados().addActionListener(this);
        this.principal.getMniInfoEmpleados().addActionListener(this);
        this.principal.getMniABCProductos().addActionListener(this);
        this.principal.getMniInfoProductos().addActionListener(this);
        this.principal.getMniABCVentas().addActionListener(this);
        this.principal.getMniInfoVentas().addActionListener(this);
        this.principal.getMniInfoCompras().addActionListener(this);
        this.principal.getMniABCPedidos().addActionListener(this);
        this.principal.getMniInfoPedidos().addActionListener(this);
        this.principal.getMniABCUsuario().addActionListener(this);
        this.principal.getMniABCMarcas().addActionListener(this);
        this.principal.getMniABCPuesto().addActionListener(this);
        this.principal.getMniABCCategoria().addActionListener(this);
        this.principal.getMniAbastecer().addActionListener(this);
        this.principal.getMniInfoAlmacen().addActionListener(this);
        this.principal.getMniSalir().addActionListener(this);
        this.principal.getMniCerrar().addActionListener(this);
        this.principal.getMniCambiarPass().addActionListener(this);
    }

    //Seccion de metodos gettes and settes

}//fin de la clase, despues de esta linea no va nada