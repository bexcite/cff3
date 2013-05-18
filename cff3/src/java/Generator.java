import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.grails.cxf.soap.PublicFactor;
import org.grails.cxf.soap.PublicFactorSet;


public class Generator {
  
  private static final double[] values = new double[] {
    112765811.6254037,
    2962932.977401314,
    3381435.329103072,
    3408047.17365485,
    1422039.176613659,
    1107795.785748322,
    403459.3540300346,
    -402734.0299783071,
    -893677.3477309718,
    -1005341.026105377,
    -1025612.667312481,
    -1018687.740097954,
    -799410.4957198879,
    -173686.5665167449,
    844407.2787930454,
    1572242.513194218,
    -7590.78766460664,
    -54026.70473405984,
    -21440.1064537095,
    -5802.012233320179,
    -32233.87636302974,
    10121.51164987648,
    1207.310559311381,
    -39927.19141741647,
    -7899.320442861367,
    -3457.920312364726,
    27681.76990322791,
    29396.46622092969,
    47161.46228175136,
    9929.863799044399,
    -3552.282843412238,
    11002.56467373796,
    -13600.33830595647,
    -27255.70962887114,
    12752.50234906327,
    4597.787704960318,
    -1487.901331849969,
    -35944.65777060398,
    595.4120962195805,
    4256.495859043778,
    -41498.93977246781,
    -2877.451850450942,
    63683.7637792059,
    13820.11335105615,
    -15086.37083674274,
    24196.94407852883,
    70104.28188067557,
    -6828333.755980406,
    2760201.599787706,
    2734718.904096749,
    2731063.955695488,
    2739322.31830865,
    2712752.194273569,
    -6821528.901255244,
    -10208330.21608946,
    -10218574.33335282,
    -10218386.44109342,
    -10241424.95692629,
    -10211877.5428704,
    2004142.077497254,
    1965879.466560283,
    1955287.870648415,
    1884518.611177143,
    8027853.000828708,
    8150610.232985636,
    8125431.847322182,
    8112798.035923412,
    8064210.453913063,
    8046891.443447848,
    8062056.199725889,
    8109320.938489715,
    1949447.188258467,
    1973827.062752179,
    2174427.780032012,
    2205855.948720405,
    -9797598.729900615,
    -9761122.797044285,
    -10159575.80144042,
    45326.47928114293,
    37923.23883057827,
    2050201.604649386
  };
  
  private static final double[] mu = new double[] {
    3001.949466246832,639.8450963827663,8365.046809000845,0.08444051916135474,0.07729821058290454,0.08509331080562169,0.08186775209277321,0.08478611473773136,0.08225174717763613,0.08520850933108057,0.08478611473773136,0.08225174717763613,0.08520850933108057,0.08171415405882805,0.08509331080562169,0.03179479302664926,0.03317717533215575,0.03302357729821058,0.03260118270486138,0.03275478073880654,0.03310037631518317,0.03279318024729284,0.03298517778972429,0.03286997926426542,0.03317717533215575,0.03310037631518317,0.03244758467091621,0.03302357729821058,0.03279318024729284,0.03302357729821058,0.03290837877275171,0.03286997926426542,0.03260118270486138,0.03306197680669688,0.03267798172183396,0.03286997926426542,0.03317717533215575,0.03290837877275171,0.03317717533215575,0.03263958221334767,0.03286997926426542,0.03240918516242992,0.03290837877275171,0.0307196067890331,0.03014361416173873,0.01939175178557714,0.1434989632132709,0.1433453651793257,0.1430381691114354,0.142462176484141,0.1426925735350588,0.1417325858229015,0.1432301666538668,0.04158666769065356,0.04158666769065356,0.04158666769065356,0.04158666769065356,0.04147146916519469,0.04158666769065356,0.04158666769065356,0.04158666769065356,0.04166346670762614,0.04162506719913985,0.04166346670762614,0.04170186621611243,0.04166346670762614,0.04150986867368098,0.04158666769065356,0.04166346670762614,0.04174026572459873,0.04177866523308502,0.04174026572459873,0.04181706474157131,0.0418554642500576,0.04189386375854389,0.04174026572459873,0.04177866523308502,0.003801551340142846,0.00418554642500576,6.707203747792028
  };
  
  private static final double[] sigma = new double[] {
    312.7650702230523,60.1765209000328,807.7348840235563,0.2780526688907528,0.2670691597779927,0.2790258569953593,0.2741683965853648,0.2785685001986987,0.2747531546966263,0.2791970854955871,0.2785685001987122,0.2747531546966146,0.279197085495585,0.273933993104179,0.2790258569953427,0.1754567362470122,0.1791024347583665,0.1787015581913785,0.1775937968921638,0.1779975328308563,0.1789021252431037,0.1780983031103184,0.1786011778181914,0.1782996480006134,0.1791024347583655,0.1789021252431039,0.1771890078667045,0.1787015581913785,0.1780983031103187,0.1787015581913785,0.1784002228322952,0.1782996480006145,0.177593796892164,0.1788018739634512,0.1777957960485647,0.1782996480006151,0.1791024347583641,0.1784002228322958,0.1791024347583639,0.1776948293229934,0.1782996480006158,0.1770876452196475,0.1784002228322961,0.1725602966272692,0.1709856699809611,0.1379001159183664,0.3505876930527259,0.3504314298183071,0.3501184919624618,0.3495302505894673,0.3497657796855982,0.3487823550663646,0.3503141424519498,0.199646555986647,0.199646555986647,0.1996465559866469,0.199646555986647,0.1993818269313568,0.1996465559866469,0.1996465559866469,0.1996465559866469,0.1998228102832652,0.1997347062680943,0.1998228102832655,0.1999108680932458,0.1998228102832655,0.1994701163798071,0.1996465559866472,0.1998228102832651,0.1999988797592795,0.2000868453421768,0.1999988797592795,0.2001747649026782,0.200262638501386,0.200350466198779,0.1999988797592797,0.2000868453421766,0.06154059616138329,0.06456150309964566,9.448220030260357
  };
  
  
  
  public static void main(final String[] args) throws ParseException {
    final PublicFactorSet set = new PublicFactorSet();
    
//    ["ConsumersCottage", "ConsumersLegal", "ConsumersFlat", "DateTime", "Event", "Temperature", "Consumers"]
    
//    114296373,ConsumersCottage=2474,ConsumersLegal=537,ConsumersFlat=6986,DateTime=2010.01.01
    PublicFactor f = new PublicFactor();
    f.setName("ConsumersCottage");
    f.setValue("2474");
    set.getFactors().add(f);
    
    f = new PublicFactor();
    f.setName("ConsumersLegal");
    f.setValue("537");
    set.getFactors().add(f);
    
    f = new PublicFactor();
    f.setName("ConsumersFlat");
    f.setValue("6986");
    set.getFactors().add(f);
    
    f = new PublicFactor();
    f.setName("DateTime");
    f.setValue("2010.01.01 19");
    set.getFactors().add(f);
    
    f = new PublicFactor();
    f.setName("Event");
    f.setValue("");
    set.getFactors().add(f);
    
    f = new PublicFactor();
    f.setName("Temperature");
    f.setValue("-4");
    set.getFactors().add(f);
    
    f = new PublicFactor();
    f.setName("Consumers");
    f.setValue("9997");
    set.getFactors().add(f);
    
//    2474 537 6986 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 -4
    
    
    
    System.out.println("Result: " + generate(set));
  }

  
  public static long generate(final PublicFactorSet set) throws ParseException {
//    long long int consumage  = [[scanner nextElement] longLongValue];
//    long long int cottage  = [[[scanner nextElement] componentsSeparatedByString:@"="][1] longLongValue];
//    long long int legal  = [[[scanner nextElement] componentsSeparatedByString:@"="][1] longLongValue];
//    long long int flat  = [[[scanner nextElement] componentsSeparatedByString:@"="][1] longLongValue];
//    NSString * dateTime  = [[scanner nextElement] componentsSeparatedByString:@"="][1];
//    NSString * event = [[scanner nextElement] componentsSeparatedByString:@"="][1];
//    long long int temperature  = [[[scanner nextElement] componentsSeparatedByString:@"="][1] longLongValue];
//    long long int consumers  = [[[scanner nextElement] componentsSeparatedByString:@"="][1] longLongValue];
//    long long int failures  = [[[scanner nextElement] componentsSeparatedByString:@"="][1] longLongValue];
//    BOOL failure  = [[scanner nextElement] rangeOfString:@"false"].location == NSNotFound;
    
    
    final Map<String, PublicFactor> factors = new HashMap<>();
    for (final PublicFactor f : set.getFactors()) {
      factors.put(f.getName(), f);
    }
//    <factors name="ConsumersCottage">3572</factors>
//    <factors name="ConsumersLegal">763</factors>
//    <factors name="ConsumersFlat">9830</factors>
//    <factors name="DateTime">2013.02.03 05</factors>
//    <factors name="Event">SHOW</factors>
//    <factors name="Temperature">-6</factors>
//    <factors name="Consumers">14165</factors>
    final double cottage = getValue(factors, "ConsumersCottage");
    final double legal = getValue(factors, "ConsumersLegal");
    final double flat = getValue(factors, "ConsumersFlat");
    final double temperature = getValue(factors, "Temperature");
    final double consumers = getValue(factors, "Consumers");
    final String event = factors.get("Event").getValue();
    final Date dateTime = new SimpleDateFormat("yyyy.MM.dd HH").parse(factors.get("DateTime").getValue());
    final Calendar dateCal = Calendar.getInstance();
    dateCal.setTime(dateTime);
    final int year = dateCal.get(Calendar.YEAR);
    final int month = dateCal.get(Calendar.MONTH) + 1;
    final int day = dateCal.get(Calendar.DAY_OF_MONTH);
    final int hour = dateCal.get(Calendar.HOUR_OF_DAY);
    final int weekDay = dateCal.get(Calendar.DAY_OF_WEEK);
    
    final List<Double> input = new ArrayList<>();
    input.addAll(Arrays.asList(cottage, legal, flat));
    for (int i =1 ; i <=12 ;i ++) {
      if (i == month) {
          input.add(1D);
      } else {
          input.add(0D);
      }
    }
    
    for (int i =1 ; i <=31 ;i ++) {
      if (i == day) {
        input.add(1D);
      } else {
        input.add(0D);
      }
  }
    
    for (int i =1 ; i <=7 ;i ++) {
      if (i == weekDay) {
        input.add(1D);
      } else {
        input.add(0D);
      }
  }
    
    for (int i =0 ; i <=23 ;i ++) {
      if (i == hour) {
        input.add(1D);
      } else {
        input.add(0D);
      }
  }
    
    if ("SPORT".equalsIgnoreCase(event)) {
      input.add(1D);
    } else {
      input.add(0D);
    }
    if ("SHOW".equalsIgnoreCase(event)) {
      input.add(1D);
    } else {
      input.add(0D);
    }
    
    input.add(temperature);

    
//    final ArrayList<Double> superArray = new ArrayList<>(Arrays.<Double>asList(2474D, 537D, 6986D, 1D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 1D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 1D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 1D, 0D, 0D, 0D, 0D, 0D, 0D, -4D));
//
//    System.out.println("Eq: " + superArray.equals(input));
//    (t-mu)./sigma
    
//    [16:28:44] (Stanfy) Taykalo Paul aka Kilew: X_norm = (X .- (t * mu)) ./ (t * sigma);
    
    System.out.println(input.toString());
    
    for (int i = 0; i < input.size(); i++) {
      input.set(i, (input.get(i) - mu[i]) / sigma[i]);
    }
    input.add(0, 1D);
    
    System.out.println(input.toString());
    
    double resultMul = 0;
    for (int i = 0; i < input.size(); i++) {
      resultMul += input.get(i) * values[i];
    }
    
    
    System.out.println(values.length + " vs " + input.size());


    System.out.println(mu.length + " vs " + sigma.length);
    
    
    
    
    
    return Math.round(resultMul);
  }
  
  private static double getValue(final Map<String, PublicFactor> map, final String name) {
    return Double.parseDouble(map.get(name).getValue());
  }
}
