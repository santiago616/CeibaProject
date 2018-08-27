package com.ceiba.estacionamiento.estacionamiento.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegistroVigilanteControllerTest {

	
	@Autowired
    private MockMvc mockMvc;
	
	
	
	@Test
    public void testGuardarRegistroEstacionamiento() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
		MockHttpServletRequestBuilder builder =MockMvcRequestBuilders.post("/registroVigilante/guardarRegistro")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"vehiculo\":{\"placa\":\"SDDD\",\"tipoVehiculo\":\"AUTO\",\"cilindraje\":\"22333\"},\"horaEntrada\":\"2018-08-27T19:06:19.756Z\"}");
		
		
		 this.mockMvc.perform(builder)
		 .andExpect(ok)
         .andDo(print());
	}
	
	@Test
    public void testGuardarRegistroEstacionamientoFailed() throws Exception {
		ResultMatcher bad = MockMvcResultMatchers.status()
                .isBadRequest();
		MockHttpServletRequestBuilder builder =MockMvcRequestBuilders.post("/registroVigilante/guardarRegistro")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"vehiculo\":{\"placa\":\"SDDD\",\"tipoVehiculo\":\"AUTO\",\"cilindraje\":\"22333\"},\"horaEntrada\":\"2018-08-27T19:06:19.756Z\"}");
		
		 this.mockMvc.perform(builder)
		 .andExpect(bad)
         .andDo(print());
	}
	
	@Test
    public void testFacturarRegistroEstacionamiento() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
		MockHttpServletRequestBuilder builder =MockMvcRequestBuilders.put("/registroVigilante/registro/{placa}","SQ282")
        .contentType(MediaType.APPLICATION_JSON);
        
		
		 this.mockMvc.perform(builder)
		 .andExpect(ok)
         .andDo(print());
	}
	
	@Test
    public void testFacturarRegistroEstacionamientoFailed() throws Exception {
		ResultMatcher bad = MockMvcResultMatchers.status()
                .isBadRequest();
		MockHttpServletRequestBuilder builder =MockMvcRequestBuilders.put("/registroVigilante/registro/{placa}","SQ666")
        .contentType(MediaType.APPLICATION_JSON);
        
		
		 this.mockMvc.perform(builder)
		 .andExpect(bad)
         .andDo(print());
	}
	
	
	@Test
    public void testConsultarRegistroEstacionamiento() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status()
                .isOk();
		MockHttpServletRequestBuilder builder =MockMvcRequestBuilders.get("/registroVigilante/registro/{placa}","SQ212")
        .contentType(MediaType.APPLICATION_JSON);
        
		
		 this.mockMvc.perform(builder)
         .andDo(print());
	}
	
	@Test
    public void testConsultarRegistroEstacionamientoFailed() throws Exception {
		ResultMatcher bad = MockMvcResultMatchers.status()
                .isBadRequest();
		MockHttpServletRequestBuilder builder =MockMvcRequestBuilders.get("/registroVigilante/registro/{placa}","SQ111")
        .contentType(MediaType.APPLICATION_JSON);
        
		
		 this.mockMvc.perform(builder)
		 .andExpect(bad)
         .andDo(print());
	}
}
