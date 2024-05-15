package org.example;

/**
 * Interfaz que da la cualidad de ser invitable
 */
public interface Invitable {
    /**
     * Invita a la reunión de la invitación
     * @param invi Inivtación a una reunión
     */
    public void invitar(Invitacion invi);

    /**
     * Devuelve el estado de invitación a la reunión
     * @return Estado de invitación
     */
    public boolean getInvitado();
}