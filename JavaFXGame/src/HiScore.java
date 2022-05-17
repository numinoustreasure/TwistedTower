//object that holds integer and name for hiscore table creation
class HiScore {
	Integer score;
	String name;
	public
	HiScore(int score, String name){
		setScore(score);
		setName(name);
	}
	String getName(){return name;}
	Integer getScore(){return score;}
	void setName(String name){this.name = name;}
	void setScore(Integer score){this.score = score;}

}


