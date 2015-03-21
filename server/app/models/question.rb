class Question < ActiveRecord::Base
	belongs_to :user
	has_many :answers
	serialize :options
end
