<div align="center">
  <img src="https://cdn-icons-png.flaticon.com/512/2331/2331966.png" width="120" />
  
  <h1>Sistema de Gestión de Colas</h1>
  
  <p>
    <strong>Simulación operativa de cajas de supermercado con estructuras dinámicas.</strong>
  </p>

  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/GUI-Swing-blue?style=for-the-badge" alt="Swing" />
  <img src="https://img.shields.io/badge/Estructura-FIFO-lightgrey?style=for-the-badge" alt="FIFO" />
  <img src="https://img.shields.io/badge/Estado-Terminado-success?style=for-the-badge" alt="Estado" />

</div>

<br />

## 📄 Descripción
Programa desarrollado en **Java** para la simulación y manejo de sistemas de colas en un supermercado. El proyecto replica el funcionamiento operativo de los puntos de venta, implementando **estructuras de datos dinámicas** y lógica de negocio basada en el principio **FIFO** (First In, First Out / Primero en entrar, primero en salir).

---

## ✨ Características Principales

| Característica | Descripción |
| :--- | :--- |
| 👥 **Gestión de Colas** | Visualización en tiempo real de clientes en espera. |
| 🏪 **Multi-Caja** | Soporte para múltiples puntos de atención (2 Cajas) mediante componentes reutilizables. |
| 🛒 **Simulación de Compras** | Generación aleatoria de carritos de compra con cálculo automático de totales. |
| ⏳ **Control de Tiempo** | Mecanismo de penalización (re-encolado) para atenciones que exceden el tiempo límite. |
| 🖥️ **Interfaz Gráfica** | Desarrollada con **Java Swing** para una experiencia de usuario fluida e interactiva. |

---

## 🛠 Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 8 o superior).
* **GUI:** Java Swing (JFrame, JPanel, JList).
* **IDE Recomendado:** Eclipse IDE / IntelliJ IDEA.
* **Control de Versiones:** Git.

---

## 📸 Capturas de Pantalla
*(Opcional: Si subes imágenes o GIFs de tu programa funcionando, agrégalos aquí usando el formato: `![Descripcion](ruta-de-imagen.png)`)*

---

## 🚀 Instalación y Ejecución

### Requisitos Previos
1.  Tener instalado el **Java Development Kit (JDK)** versión 8 o superior.
2.  Tener un IDE compatible con Java (Eclipse, NetBeans, IntelliJ) o una terminal configurada.

### Pasos para ejecutar

1.  **Clonar o Descargar:** Descarga este repositorio en tu equipo.
2.  **Importar:** Abre el proyecto en tu IDE de preferencia.
3.  **Localizar el Main:** Navegue dentro del paquete `gestion_colas` y localice el archivo `Main.java`.
4.  **Ejecutar:** * *En Eclipse:* Clic derecho sobre el archivo > `Run As` > `Java Application`.
    * *En Terminal:* `javac Main.java` seguido de `java Main`.

---

## 📖 Manual de Uso

### 1. Ingreso de Clientes
* Escriba el nombre del cliente en el campo superior.
* Presione el botón **"Nuevo Cliente"** para agregarlo a la cola general.

### 2. Atención en Cajas
* Seleccione **"Llamar Cliente"** en cualquiera de las dos cajas disponibles para despachar al siguiente en la cola.

### 3. Gestión de Transacción
* 💰 **Cobrar:** Finaliza la transacción y permite elegir el método de pago.
* ⏱️ **Tiempo Agotado:** Simula una demora excesiva; el cliente será penalizado y volverá al final de la cola.
* 🔒 **Cerrar Caja:** Inhabilita un punto de venta temporalmente.

---

## 👨‍💻 Autores

| Nombre | Rol | GitHub |
| :--- | :--- | :--- |
| **Francisco Fonseca** | Desarrollo y Documentación | [@UsuarioFrancisco](https://github.com/) |
| **Jesús Colmenares** | Desarrollo y Documentación | [@JesusShady](https://github.com/JesusShady) |

---
<div align="center">
  <small>Proyecto realizado para la UNEG - Semestre IV - Técnicas de Programación 3</small>
</div>
