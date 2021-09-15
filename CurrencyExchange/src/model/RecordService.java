package model;


public class RecordService {
	private  RecordDAO dao;
	public RecordService() {
		dao = new RecordDAOImpl();
	}
	
	public RecordVO addRecord(
			 Double rate,
			 String currency,
			 Double price,
			 Double discount,
			 Double result
			) {
		RecordVO recordVO = new RecordVO();
		recordVO.setRate(rate);
		recordVO.setCurrency(currency);
		recordVO.setPrice(price);
		recordVO.setDiscount(discount);
		recordVO.setResult(result);
		dao.insert(recordVO);
		
		return recordVO;
	}
}
