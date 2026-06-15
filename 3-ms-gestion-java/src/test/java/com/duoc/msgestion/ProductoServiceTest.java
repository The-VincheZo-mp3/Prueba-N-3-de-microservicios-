package com.duoc.msgestion; import static org.junit.jupiter.api.Assertions.assertEquals;
 import static org.junit.jupiter.api.Assertions.assertNotNull;
 import org.junit.jupiter.api.Test;
 import org.junit.jupiter.api.extension.ExtendWith;
 import static org.mockito.ArgumentMatchers.any;
 import org.mockito.InjectMocks;
 import org.mockito.Mock;
 import org.mockito.Mockito;
 import org.mockito.junit.jupiter.MockitoExtension;

 import com.duoc.msgestion.model.Producto;
 import com.duoc.msgestion.repository.ProductoRepository;
import com.duoc.msgestion.service.ProductoService;
 @ExtendWith(MockitoExtension.class) public class ProductoServiceTest { @Mock private ProductoRepository repository; @InjectMocks private ProductoService service; @Test public void testGuardarProductoCorrectamente() { Producto mock = new Producto("Teclado Mecanico RGB", 45000.0); Mockito.when(repository.save(any(Producto.class))).thenReturn(mock); Producto resultado = service.guardarProducto(new Producto("Teclado Mecanico RGB", 45000.0)); assertNotNull(resultado); assertEquals("Teclado Mecanico RGB", resultado.getNombre()); } }