import java.util.Objects;

public class address {
    private String calle, ciudad, estado, codigo;

    public address(String calle, String ciudad, String estado, String codigo) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigo = codigo;
    }

    public String getCiudad() {
        return ciudad;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        address addr = (address) o;
        return Objects.equals(calle, addr.calle) && Objects.equals(ciudad, addr.ciudad) && Objects.equals(estado, addr.estado) && Objects.equals(codigo, addr.codigo);
    }

    @Override
    public String toString() {
        return "DIRECCIÓN: " +
                "Calle: " + calle + " // " +
                "Ciudad: '" + ciudad + " // " +
                "Estado: " + estado + " // " +
                "Código: " + codigo;
    }
}
