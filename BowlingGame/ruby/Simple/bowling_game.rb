class BowlingGame

  def initialize
    @rolls = []
  end

  def roll(*pins_hit)
    @rolls.concat pins_hit
  end

  def score
    roll_num = 0
    score = 0

    10.times do
      if strike?(roll_num)
        score += 10 + strike_bonus(roll_num)
        roll_num += 1
      elsif spare?(roll_num)
        score += 10 + spare_bonus(roll_num)
        roll_num += 2
      else
        score += sum_frame(roll_num)
        roll_num += 2
      end
    end

    score
  end

  private

  def strike?(roll_num)
    @rolls[roll_num] == 10
  end

  def spare?(roll_num)
    @rolls[roll_num] + @rolls[roll_num + 1] == 10
  end

  def strike_bonus(roll_num)
    @rolls[roll_num + 1] + @rolls[roll_num + 2]
  end

  def spare_bonus(roll_num)
    @rolls[roll_num + 2]
  end

  def sum_frame(roll_num)
    @rolls[roll_num] + @rolls[roll_num + 1]
  end
end