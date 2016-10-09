package pe.egcc.app.service.impl;

import pe.egcc.app.service.espec.MateServEspec;

/**
 *
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 * @email gcoronelc@gmail.com
 */
public class MateServiceImpl implements MateServEspec {

  @Override
  public int sumar(int n1, int n2) {
    int r;
    r = n1 + n2;
    return r;
  }

}
