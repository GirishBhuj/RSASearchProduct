package Learning;

public class IndianTrafficRules implements WorldTrafficRulesInterface,ContinetTrafficRulesInterface
{
	public static void main(String[] args)
	{
		WorldTrafficRulesInterface mWorldTrafficRules = new IndianTrafficRules();
		mWorldTrafficRules.GreenGo();
		mWorldTrafficRules.RedStop();
		mWorldTrafficRules.YellowFlash();

		
		IndianTrafficRules mIndiaSpecificRules = new IndianTrafficRules();
		mIndiaSpecificRules.IndiaWalk();
		mIndiaSpecificRules.GreenGo();
		mIndiaSpecificRules.RedStop();
		mIndiaSpecificRules.YellowFlash();
		
		ContinetTrafficRulesInterface mContinetTrafficRules = new IndianTrafficRules();
		mContinetTrafficRules.WaterGreenGo();
	}
	
	public void IndiaWalk()
	{
		System.out.println("IndiaWalk()");				
	}

	@Override
	public void GreenGo() 
	{
		System.out.println("GreenGo()");		
	}

	@Override
	public void RedStop() 
	{
		System.out.println("RedStop()");	
	}

	@Override
	public void YellowFlash() 
	{
		System.out.println("FlashYellow()");
	}

	@Override
	public void WaterGreenGo() 
	{
		System.out.println("WaterGreenGo()");		
	}
}