package rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/calculoimc")
public class MenorMaiorRestServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

		//Prepara para a execucao.
		String alturaStr = request.getParameter("altura");
		String pesoStr = request.getParameter("peso");
		
		if (alturaStr == null || pesoStr == null && alturaStr == "" || pesoStr ==""){
			alturaStr = "0";
			pesoStr = "0";
		}
		
		float peso = Float.valueOf(pesoStr);
		float altura = Float.valueOf(alturaStr);
		System.out.println(altura);
		System.out.println(peso);
		
		//Executa "regras de negocio".
		ImcModel ImcModel = new ImcModel(altura,peso);
		String resultado = ImcModel.resultado();
		

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getOutputStream().print(
                "{"
                + "\"resultado\":\"" + resultado + "\","
                + "\"altura\":\"" + altura + "\""
                + "\"peso\":\"" + peso + "\""
              + "}");
    	
    	// classe 
       
    }

}
