/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.evoli.cte.util;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author edivaldo
 */
public class CTeUtil {

  public static br.inf.portalfiscal.cte.CteProc getCTeByXml(File file) throws Exception {
    JAXBContext context = null;
    try {
      context = JAXBContext.newInstance("br.inf.portalfiscal.cte");
    } catch (JAXBException ex) {
      ex.printStackTrace();
      throw new Exception("Erro ao instaciar JAXBContext br.inf.portalfiscal.cte.", ex.fillInStackTrace());
    }

    Unmarshaller unmarshaller = null;
    try {
      unmarshaller = context.createUnmarshaller();
    } catch (JAXBException ex) {
      ex.printStackTrace();
      throw new Exception("Erro ao criar o unmarshaller.", ex.fillInStackTrace());
    }

    br.inf.portalfiscal.cte.CteProc protCTe = null;
    try {
      //protCTe = unmarshaller.unmarshal(new StreamSource(file), br.inf.portalfiscal.cte.CteProc.class).getValue();
      protCTe = (br.inf.portalfiscal.cte.CteProc) unmarshaller.unmarshal(file);
      //protCTe = (br.inf.portalfiscal.cte.CteProc) unmarshaller.unmarshal(new StreamSource(file));
    } catch (JAXBException ex) {
      ex.printStackTrace();
      throw new Exception("Erro ao executar unmarshaller de: br.inf.portalfiscal.cte.CteProc.class", ex.fillInStackTrace());
    }
    return protCTe;
  }
}
