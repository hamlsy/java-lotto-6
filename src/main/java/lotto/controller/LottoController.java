package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    //todo create start method
    // before lotto, start lotto, result lotto impl
    private LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start(){
        // input lotto
        createLottos();
        // start lotto
        // result lotto
    }


    //todo create input lotto(before lotto) method
    public void createLottos(){
        //Lotto Service 코드
        lottoService.createLottos();
    }

    //todo create start lotto method


    //todo create result lotto method


}
