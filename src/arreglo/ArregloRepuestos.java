package arreglo;

import java.util.ArrayList;
import java.util.List;
import clases.Repuestos;
import clases.Tiendas;

public class ArregloRepuestos {
    private List<Repuestos> repuestos;

    public ArregloRepuestos() {
        repuestos = new ArrayList<>();
    }

    public void adicionarRepuesto(Repuestos repuesto) {
        repuestos.add(repuesto);
    }

    public Repuestos consultarRepuesto(String codigo) {
        for (Repuestos repuesto : repuestos) {
            if (repuesto.getCodigo().equals(codigo)) {
                return repuesto;
            }
        }
        return null;
    }

    public void modificarRepuesto(Repuestos repuestoModificado) {
        for (Repuestos repuesto : repuestos) {
            if (repuesto.getCodigo().equals(repuestoModificado.getCodigo())) {
                repuesto.setNombre(repuestoModificado.getNombre());
                repuesto.setPrecio(repuestoModificado.getPrecio());
                repuesto.setCantidad(repuestoModificado.getCantidad());
                repuesto.setEstado(repuestoModificado.getEstado());
                break;
            }
        }
    }

    public void eliminarRepuesto(String codigo) {
        repuestos.removeIf(repuesto -> repuesto.getCodigo().equals(codigo));
    }

    public List<Repuestos> obtenerTodosRepuestos() {
        return new ArrayList<>(repuestos);
    }
}