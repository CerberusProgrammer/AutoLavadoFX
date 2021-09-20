public class Vehiculo {

    int preferencia;
    String tamaño;
    int lavado;
    int secado;

    int TiempoTotal;
    int horaEntrada;
    int horaSalida;

    public Vehiculo(int preferencia, String tamaño, int lavado, int secado, int horaEntrada) {
        this.preferencia = preferencia;
        this.tamaño = tamaño;
        this.lavado = lavado;
        this.secado = secado;
        this.horaEntrada = horaEntrada;
    }

    public int getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(int preferencia) {
        this.preferencia = preferencia;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public int getLavado() {
        return lavado;
    }

    public void setLavado(int lavado) {
        this.lavado = lavado;
    }

    public int getSecado() {
        return secado;
    }

    public void setSecado(int secado) {
        this.secado = secado;
    }

    public int getTiempoTotal() {
        return TiempoTotal;
    }

    public void setTiempoTotal(int tiempoTotal) {
        TiempoTotal = tiempoTotal;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "preferencia=" + preferencia +
                ", tamaño='" + tamaño + '\'' +
                ", lavado=" + lavado +
                ", secado=" + secado +
                ", TiempoTotal=" + TiempoTotal +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                '}';
    }
}
