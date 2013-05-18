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
    112496610.4409422,
    3996099.465035902,
    3316984.063654415,
    4401928.085045462,
    152714.0166044143,
    1155793.033223247,
    857519.6900045215,
    224230.3071689047,
    -522994.6925550168,
    -853357.8287253188,
    -893638.3167309955,
    -939333.5798603785,
    -888896.8536775319,
    -718495.9304064271,
    8802.340031995691,
    973107.449615296,
    1619331.297911034,
    -24820.67353597018,
    -79206.9758026224,
    -1399.325383321208,
    4585.84966296427,
    -62358.08017991261,
    2358.981521389653,
    9427.385535751273,
    -75220.768981641,
    -19964.93778588793,
    26173.1649549018,
    36218.31852074384,
    25523.18847994834,
    45620.02136004498,
    20097.73097139408,
    -16278.2184059564,
    -13812.37071882986,
    7711.83829118358,
    -36045.76085356549,
    5316.197135106039,
    8917.754966061559,
    9247.904180827045,
    -44240.27634850755,
    -16300.3767958717,
    24662.98923228552,
    403.9999248608455,
    2395.052584810234,
    24782.71030588609,
    29503.22443105261,
    -20657.56529995833,
    48496.28850014068,
    103364.747527374,
    -6865811.854749477,
    2802178.293847483,
    2735082.054879253,
    2742012.667128599,
    2759333.980854651,
    2714527.614045141,
    -6845647.832287142,
    -10214286.44309053,
    -10233006.96293599,
    -10235977.02636573,
    -10262516.90022922,
    -10227811.62370146,
    1991961.73401615,
    1957311.668472079,
    1949895.138915024,
    1919903.120403858,
    8013575.683544273,
    8137035.932069743,
    8110151.873526365,
    8102269.720903421,
    8056638.805007135,
    8043625.418831686,
    8060076.885861807,
    8107893.340938965,
    1996044.27421278,
    2021944.366390318,
    2220305.699589246,
    2241969.12479523,
    -9795886.347920638,
    -9758316.860355666,
    -10164804.05674863,
    71054.42590890617,
    -17266.38933038936,
    1617811.640233207
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
    input.addAll(Arrays.asList(1D, cottage, legal, flat));
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
    
//    System.out.println(input.toString());
    
//    final ArrayList<Double> superArray = new ArrayList<>(Arrays.<Double>asList(2474D, 537D, 6986D, 1D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 1D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 1D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 0D, 1D, 0D, 0D, 0D, 0D, 0D, 0D, -4D));
//
//    System.out.println("Eq: " + superArray.equals(input));
    
    double resultMul = 0;
    for (int i = 0; i < input.size(); i++) {
      resultMul += input.get(i) * values[i];
    }
    
    return Math.round(resultMul);
  }
  
  private static double getValue(final Map<String, PublicFactor> map, final String name) {
    return Double.parseDouble(map.get(name).getValue());
  }
}
