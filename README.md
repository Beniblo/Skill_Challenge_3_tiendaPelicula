# Registro de Excepciones Implementadas en el Proyecto TiendaPeliculas

Este documento presenta las excepciones personalizadas añadidas para el manejo de errores en las entidades Cliente, Película y Renta, así como las actualizaciones realizadas en los servicios y en el manejo global de excepciones.

---

## 1. Excepciones para la entidad Cliente

Ubicación: `com.metaphorce.tiendaPeliculas.excepciones`

- **ClienteNoEncontradoException:**  
  Excepción lanzada cuando se solicita un cliente por ID que no existe en la base de datos.

- **ClienteDatosInvalidosException:**  
  Se utiliza para validar la entrada de datos en operaciones de creación o actualización, como campos obligatorios vacíos o formato incorrecto.

- **OperacionNoPermitidaException:**  
  Se emplea para impedir operaciones no autorizadas o inválidas sobre clientes, por ejemplo, al intentar eliminar un cliente inexistente.

---

## 2. Excepciones para la entidad Película

Ubicación: `com.metaphorce.tiendaPeliculas.excepciones`

- **PeliculaNoEncontradaException:**  
  Se lanza cuando una película con un ID especificado no existe en el sistema.

- **PeliculaDatosInvalidosException:**  
  Aplica para validar datos erróneos o faltantes durante la creación o actualización de una película (ej. título vacío).

- **OperacionNoPermitidaException:**  
  Reutilizada para casos donde no es posible realizar una operación válida sobre películas, como obtener una lista vacía.

---

## 3. Excepciones para la entidad Renta

Ubicación: `com.metaphorce.tiendaPeliculas.excepciones`

- **RentaNoEncontradaException:**  
  Indica que una renta solicitada por ID no existe.

- **RentaDatosInvalidosException:**  
  Validación de datos incorrectos o inconsistentes en las rentas, incluyendo fechas inválidas, estados no permitidos o referencias a Cliente o Película inexistentes.

- **OperacionNoPermitidaException:**  
  Usada para evitar operaciones inválidas, como intentar listar rentas cuando no existen registros.

---

## 4. Actualizaciones en los Servicios

Cada servicio correspondiente (`ClienteServiceImp`, `PeliculaServiceImp`, `RentaServiceImp`) fue actualizado para:

- Lanzar las excepciones personalizadas en casos de:
  - Entidades no encontradas.
  - Validaciones fallidas de datos.
  - Operaciones no permitidas por reglas de negocio.

- Validar la existencia de entidades relacionadas (por ejemplo, en Renta validar que Cliente y Película existan antes de guardar).

---

## 5. Manejo Global de Excepciones

Se amplió la clase `GlobalExceptionHandler` con métodos para capturar y responder adecuadamente a:

- `ClienteNoEncontradoException`, `ClienteDatosInvalidosException`
- `PeliculaNoEncontradaException`, `PeliculaDatosInvalidosException`
- `RentaNoEncontradaException`, `RentaDatosInvalidosException`
- `OperacionNoPermitidaException`
- Manejo de errores de validación (`MethodArgumentNotValidException`) para campos con anotaciones como `@NotNull`, `@Email`, etc.

Cada excepción devuelve una respuesta JSON con:

- Código HTTP adecuado (400, 403, 404)
- Mensajes claros indicando el error y el campo afectado cuando aplique

---

## 6. Beneficios

- Mejora significativa en la robustez y confiabilidad de la API.
- Facilita la identificación rápida de errores para desarrolladores y consumidores.
- Código mantenible y modular, facilitando futuras ampliaciones o cambios.

---

