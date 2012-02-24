$:.unshift File.dirname(__FILE__)

require "minitest/unit"
require "minitest/autorun"
require 'bowling_game'

class BowlingGameTest < MiniTest::Unit::TestCase

  def setup
    @game = BowlingGame.new
  end

  def test_gutter_game
    roll_many 20, 0
    assert_equal 0, @game.score
  end

  def test_roll_all_ones
    roll_many 20, 1
    assert_equal 20, @game.score
  end

  def test_roll_spare
    roll_spare
    roll_many 17, 0

    assert_equal 16, @game.score
  end

  def test_roll_strike
    roll_strike
    roll_many 16, 0

    assert_equal 24, @game.score
  end

  def test_roll_perfect_game
    roll_many 12, 10
    assert_equal 300, @game.score
  end

  def roll_many(num, pins_hit)
    num.times { @game.roll pins_hit}
  end

  def roll_strike
    @game.roll 10, 3, 4
  end

  def roll_spare
    @game.roll 5, 5, 3
  end
end