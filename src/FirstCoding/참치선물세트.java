package FirstCoding;

class 참치선물세트 {
	int 일반;
	int 야채;
	int 고추;

	참치선물세트(int 일반, int 야채, int 고추) {
		this.일반 = 일반;
		this.야채 = 야채;
		this.고추 = 고추;
	}
	
	public int get일반() {
		return 일반;
	}

	public void set일반(int 일반) {
		this.일반 = 일반;
	}

	public int get야채() {
		return 야채;
	}

	public void set야채(int 야채) {
		this.야채 = 야채;
	}

	public int get고추() {
		return 고추;
	}

	public void set고추(int 고추) {
		this.고추 = 고추;
	}

	int 총합() {
		int 전체개수;
		전체개수 = this.일반 + this.야채 + this.고추;
		return 전체개수;
	}
	
}
